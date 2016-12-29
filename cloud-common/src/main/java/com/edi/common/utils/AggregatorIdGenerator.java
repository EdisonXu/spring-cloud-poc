package com.edi.common.utils;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by Edison Xu on 2016/12/27.
 */

public enum AggregatorIdGenerator {

    instance;

    @Value("${distribute_index}")
    private long index=0;
    private DistributeUniqueId id = new DistributeUniqueId(index);

    public long generate(){
        return id.generate();
    }
}
