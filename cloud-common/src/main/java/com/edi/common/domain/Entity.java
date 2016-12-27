package com.edi.common.domain;

/**
 * Created by Edison Xu on 2016/12/27.
 */
public class Entity {

    private CommandEvent event;
    private Long aggId;

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
}
