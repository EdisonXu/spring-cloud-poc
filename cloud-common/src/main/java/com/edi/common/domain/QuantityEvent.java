package com.edi.common.domain;

/**
 * Created by Edison Xu on 2017/1/3.
 */
public class QuantityEvent extends Entity{

    private long targetId;
    private int amount;
    private QuantityEventType type;

    public QuantityEvent() {
    }

    public QuantityEvent(long targetId, int amount, QuantityEventType type) {
        this.targetId = targetId;
        this.amount = amount;
        this.type = type;
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

    public QuantityEventType getType() {
        return type;
    }

    public void setType(QuantityEventType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuantityEvent)) return false;

        QuantityEvent that = (QuantityEvent) o;

        if (targetId != that.targetId) return false;
        if (amount != that.amount) return false;
        return type == that.type;
    }

    @Override
    public int hashCode() {
        int result = (int) (targetId ^ (targetId >>> 32));
        result = 31 * result + amount;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

}
