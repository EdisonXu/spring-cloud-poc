package com.edi.services.web.controllers;

import com.edi.common.domain.CommandEvent;
import com.edi.common.domain.Order;
import com.edi.common.domain.OrderProduct;
import com.edi.common.utils.AggregatorIdGenerator;
import com.edi.common.web.ifc.OrderService;
import com.edi.common.web.ifc.OrderState;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Edison Xu on 2016/12/15.
 */
@RestController
public class OrderController implements OrderService {

    private final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private SqlSession sqlSession;

    @Autowired
    private DiscoveryClient client;

    @Autowired
    private HttpServletRequest request;

    @Override
    @Transactional
    public void createOrder(@RequestBody Order order) {
        logInstanceInfor();
        long aggId = AggregatorIdGenerator.instance.generate();
        long orderId = AggregatorIdGenerator.instance.generate();
        order.setId(orderId);
        order.setAggId(aggId);
        order.setEvent(CommandEvent.COMMIT);
        for(OrderProduct each:order.getProducts()){
            each.setOrderId(orderId);
            each.setAggId(aggId);
        }
        //sqlSession.getConfiguration().setDefaultExecutorType(ExecutorType.BATCH);
        sqlSession.insert("insertOrder", order);
        sqlSession.insert("insertOrderProducts", order.getProducts());
    }

    @Override
    public void updateOrder(@PathVariable long id, @RequestBody Order order) {
        logInstanceInfor();
        long aggId = AggregatorIdGenerator.instance.generate();
        order.setAggId(aggId);
        order.setEvent(CommandEvent.COMMIT);
        this.sqlSession.insert("insertOrder", order);
        if(!order.getProducts().isEmpty()){
            for(OrderProduct each:order.getProducts()){
                each.setAggId(aggId);
            }
            sqlSession.insert("insertOrderProducts", order.getProducts());
        }
    }

    @Override
    public Order getOrder(@PathVariable long id) {
        logInstanceInfor();
        Order o = new Order(id);
        o.setEvent(CommandEvent.COMMIT);
        Order result = sqlSession.selectOne("readOrder", o);
        List<OrderProduct> products = sqlSession.selectList("readOrderProducts", o);
        result.setProducts(products);
        return result;
    }

    @Override
    public List<Order> getOrders() {
        logInstanceInfor();
        return sqlSession.selectList("readOrder", new Order());
    }

    @Override
    public void deleteOrder(@PathVariable long id) {
        logInstanceInfor();
        this.sqlSession.delete("deleteOrder", id);
    }

    private void logInstanceInfor() {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info(request.getMethod() + ":" + request.getRequestURL() + ", host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
    }
}
