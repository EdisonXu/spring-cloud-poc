package com.edi.services.web.controllers;

import com.edi.common.domain.CommandEvent;
import com.edi.common.domain.Product;
import com.edi.common.domain.QuantityEvent;
import com.edi.common.utils.AggregatorIdGenerator;
import com.edi.common.web.ifc.ProductService;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edison Xu on 2016/12/15.
 */
@RestController
public class ProductController implements ProductService {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private SqlSession sqlSession;

    @Autowired
    private DiscoveryClient client;

    @Autowired
    private HttpServletRequest request;

    @Override
    public void createProduct(@RequestBody Product product) {
        logInstanceInfor();
        product.setAggId(AggregatorIdGenerator.instance.generate());
        product.setEvent(CommandEvent.COMMIT);
        sqlSession.insert("insertProduct",product);
    }

    @Override
    public void updateProduct(@PathVariable long id, @RequestBody Product product) {
        logInstanceInfor();
        product.setAggId(AggregatorIdGenerator.instance.generate());
        product.setEvent(CommandEvent.COMMIT);
        //this.sqlSession.update("updateUser", user);
        this.sqlSession.insert("insertProduct", product);
    }

    @Override
    public void updateInventory(@RequestBody ArrayList<QuantityEvent> events){
        if(null == events || events.isEmpty()) {
            LOGGER.info("Ignore empty inventory event");
            return;
        }
        LOGGER.info(events.toString());
        this.sqlSession.insert("updateInventory", events);
    }

    @Override
    public Product getProduct(@PathVariable long id) {
        logInstanceInfor();
        Product p = new Product(id);
        p.setEvent(CommandEvent.COMMIT);
        return sqlSession.selectOne("readProduct", p);
    }

    @Override
    public List<Product> getProducts() {
        logInstanceInfor();
        return sqlSession.selectList("readProduct", new Product());
    }

    @Override
    public void deleteProduct(@PathVariable long id) {
        logInstanceInfor();
        this.sqlSession.delete("deleteProduct",id);
    }

    private void logInstanceInfor() {
        ServiceInstance instance = client.getLocalServiceInstance();
        LOGGER.info(request.getMethod()+":" + request.getRequestURL()+ ", host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
    }
}
