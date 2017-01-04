package com.edi.common.domain;

/**
 * Created by Edison Xu on 2017/1/3.
 */
public class QuantityEvent extends Entity{

    private long targetId;
    private int amount;
    private EventType eventType;

    public QuantityEvent() {
    }

    public QuantityEvent(long targetId, int amount, EventType eventType) {
        this.targetId = targetId;
        this.amount = amount;
        this.eventType = eventType;
    }

    public long getTargetId() {
        return targetId;
    }

    public void setTargetId(long targetId) {
        this.targetId = targetId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuantityEvent that = (QuantityEvent) o;

        if (targetId != that.targetId) return false;
        if (amount != that.amount) return false;
        return eventType == that.eventType;
    }

    @Override
    public int hashCode() {
        int result = (int) (targetId ^ (targetId >>> 32));
        result = 31 * result + amount;
        result = 31 * result + (eventType != null ? eventType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "QuantityEvent{" +
                "targetId=" + targetId +
                ", amount=" + amount +
                ", eventType=" + eventType +
                '}';
    }

    public enum EventType{
        ADD,REDUCE;
    }

}
