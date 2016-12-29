package com.edi.common.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;

/**
 * A unqiue id in the distribute cluster, composited by<br>
 * <table>
 *  <tr>
 *      <td><code>time |</code></td>
 *      <td><code>region |</code></td>
 *      <td><code>machine |</code></td>
 *      <td><code>sequence</code></td>
 *
 *  </tr>
 *  <tr>
 *      <td>&nbsp<code>41</code></td>
 *      <td>&nbsp<code>3</code></td>
 *      <td>&nbsp<code>10</code></td>
 *      <td>&nbsp<code>10</code></td>
 *  </tr>
 * </table>
 * <code>time</code>: second level filling the first 32 bit<br>
 * <code>region</code>: a unqiue number of the region where the current server is located<br>
 * <code>machine</code>: a unqiue number of the server where the jvm is current running<br>
 * <code>sequence</code>: a unique sequence per second<br>
 * <br>
 * Created by Edison Xu on 2016/12/27.
 */
public class DistributeUniqueId {

    // 基准时间
    private long twepoch = 1288834974657L; //Thu, 04 Nov 2010 01:42:54 GMT

    // 递增序号位数
    private final static long seqBits = 10L;
    // 机器编号位数
    private final static long workerIdBits = 10L;
    // 区域编号位数
    private final static long regionIdBits = 3L;

    // 递增序号最大值
    private final static long maxSeqId = -1L ^ (-1L << seqBits);
    // 机器编号最大值
    private final static long maxWorkerId = -1L ^ (-1L << workerIdBits);
    // 区域编号最大值
    private final static long maxRegionId = -1L ^ (-1L << regionIdBits);

    // 机器编号左移10位
    private final static long workerIdShift = seqBits;
    // 区域编号左移位20位
    private final static long regionIdShift = workerIdBits + seqBits;
    // 时间毫秒左移23位
    private final static long timestampLeftShift = workerIdBits + seqBits + regionIdBits;

    private final long workerId;
    private final long regionId;
    private long seq=0l ;
    private long lastFetchTime=-1l;

    private static final Logger LOGGER = LoggerFactory.getLogger(DistributeUniqueId.class);

    public DistributeUniqueId(long workerId) {
        this(workerId, 0);
    }

    public DistributeUniqueId(long workerId, long regionId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException("worker Id can't be greater than %d or less than 0");
        }
        if (regionId > maxRegionId || regionId < 0) {
            throw new IllegalArgumentException("region Id can't be greater than %d or less than 0");
        }

        this.workerId = workerId;
        this.regionId = regionId;
    }

    public long generate(){
        return nextId();
    }

    private synchronized long nextId() {
        long currentTime = System.currentTimeMillis();

        // should never happen
        if (currentTime < lastFetchTime)
            LOGGER.warn("Clock moved backwards! Could generate duplicate id!");

        // 如果本次取值与上次取值在同一毫秒内，序号递增
        if(currentTime == lastFetchTime){
            // 自增，并去掉高位
            seq = (seq+1)&maxSeqId;
            // 判断去掉高位后是否溢出，如果溢出等待到下一秒
            if(seq == 0)
                currentTime = waitTillNextMillis();
        }else{
            // 如果和上次生成时间不同,重置sequence，就是下一毫秒开始，sequence计数重新从0开始累加,
            // 为了保证尾数随机性更大一些,最后一位设置一个随机数
            seq = new SecureRandom().nextInt(10);
        }
        lastFetchTime = currentTime;

        return (lastFetchTime-twepoch)<<timestampLeftShift | regionId<<regionIdShift | workerId<<workerIdShift | seq;
    }

    private long waitTillNextMillis(){
        while(true){
            long now = System.currentTimeMillis();
            if(now > lastFetchTime)
                return now;
        }
    }
}
