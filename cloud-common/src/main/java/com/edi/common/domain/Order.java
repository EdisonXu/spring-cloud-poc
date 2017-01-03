package com.edi.common.domain;


import java.util.List;

/**
 * Created by Edison Xu on 2016/12/28.
 */
public class Order extends Entity {

    private Long id;
    private Long userId;
    private String userName;
    private List<OrderProduct> products;
    private OrderState state = OrderState.NEW;

    public Order() {
    }

    public Order(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<OrderProduct> getProducts() {
        return products;
    }

    public void setProducts(List<OrderProduct> products) {
        this.products = products;
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
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        if (!getId().equals(order.getId())) return false;
        if (!getUserId().equals(order.getUserId())) return false;
        if (getUserName() != null ? !getUserName().equals(order.getUserName()) : order.getUserName() != null)
            return false;
        if (getProducts() != null ? !getProducts().equals(order.getProducts()) : order.getProducts() != null)
            return false;
        return getState().equals(order.getState());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getUserId().hashCode();
        result = 31 * result + (getUserName() != null ? getUserName().hashCode() : 0);
        result = 31 * result + (getProducts() != null ? getProducts().hashCode() : 0);
        result = 31 * result + getState().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", products=" + products +
                ", state='" + state + '\'' +
                '}';
    }
}
