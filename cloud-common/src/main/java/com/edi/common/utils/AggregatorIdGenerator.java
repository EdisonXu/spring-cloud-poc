package com.edi.common.utils;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by Edison Xu on 2016/12/27.
 */

public enum AggregatorIdGenerator {

    instance;

    @Value("${distribute_index}")
    private long index=0;
    private DistributeUniqueId id;

    public long getId(){
        if(id == null)
            id = new DistributeUniqueId(index);
        return id.getValue();
    }
}
