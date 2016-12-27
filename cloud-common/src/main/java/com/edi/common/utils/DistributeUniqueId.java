package com.edi.common.utils;


/**
 * A unqiue id in the distribute cluster, composited by<br>
 * <table>
 *  <tr>
 *      <td><code>time |</code></td>
 *      <td><code>sequence |</code></td>
 *      <td><code>index</code></td>
 *  </tr>
 *  <tr>
 *      <td>&nbsp<code>32</code></td>
 *      <td>&nbsp<code>19</code></td>
 *      <td>&nbsp<code>13</code></td>
 *  </tr>
 * </table>
 * <code>time</code>: second level filling the first 32 bit<br>
 * <code>sequence</code>: a unique sequence per second<br>
 * <code>index</code>: a unqiue number for the program trying to generate this id<br>
 *
 * @author Edison Xu
 *
 * Jan 9, 2014
 */
public class DistributeUniqueId {

    private int seq;
    private long lastFetchTime;
    private long index;

    public static final String INDEX_KEY = "uniqueId.index.key";

    public DistributeUniqueId(long idx) {
        super();
        this.seq = 0;
        this.index = idx;
    }

    private long getSequence() {
        long now = System.currentTimeMillis();
        if(now - lastFetchTime>=1000)
        {
            seq = 0;
        }
        this.lastFetchTime = now;
        return seq++;
    }

    public long getIndex() {
        return index;
    }

    public long getValue()
    {
        long time = System.currentTimeMillis()/1000;
        long result = (time<<32) | (getSequence()<<13) | index;
        return result;
    }
}
