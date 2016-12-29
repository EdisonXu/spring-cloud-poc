package com.edi.common.web.ifc;

import com.edi.common.domain.Order;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Edison Xu on 2016/12/27.
 */
public interface OrderService {

    @RequestMapping(method = RequestMethod.POST, value = "/order")
    public void createOrder(@RequestBody Order order);

    @RequestMapping(method = RequestMethod.PUT, value = "/order/{id}")
    public void updateOrder(@PathVariable long id, @RequestBody Order order);

    @RequestMapping(method = RequestMethod.GET, value = "/order/{id}")
    public Order getOrder(@PathVariable long id);

    @RequestMapping(method = RequestMethod.GET, value = "/order")
    public List<Order> getOrders();

    @RequestMapping(method = RequestMethod.DELETE, value = "/order/{id}")
    public void deleteOrder(@PathVariable long id);

}