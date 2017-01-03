package com.edi.common.domain;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Edison Xu on 2016/12/27.
 */
public class Entity implements Serializable{

    private CommandEvent event = CommandEvent.COMMIT;
    private Long aggId;
    @JSONField(format = "yyyy-MM-dd")
    private Date createTime;

    public CommandEvent getEvent() {
        return event;
    }

    public void setEvent(CommandEvent event) {
        this.event = event;
    }

    public Long getAggId() {
        return aggId;
    }

    public void setAggId(Long aggId) {
        this.aggId = aggId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
