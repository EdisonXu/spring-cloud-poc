package com.edi.common.domain;


/**
 * Created by Edison Xu on 2016/12/28.
 */
public class OrderProduct extends Product {

    private Long orderId;
    private OrderState state = OrderState.NEW;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderProduct)) return false;
        if (!super.equals(o)) return false;

        OrderProduct that = (OrderProduct) o;

        if (!getOrderId().equals(that.getOrderId())) return false;
        return getState() == that.getState();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getOrderId().hashCode();
        result = 31 * result + getState().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ProductOrder{" +
                "orderId=" + orderId +
                ", state=" + state +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", amount=" + getAmount() +
                '}';
    }
}
