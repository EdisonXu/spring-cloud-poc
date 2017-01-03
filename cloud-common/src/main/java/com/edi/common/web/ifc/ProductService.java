package com.edi.common.web.ifc;

import com.edi.common.domain.Product;
import com.edi.common.domain.QuantityEvent;
import com.edi.common.domain.QuantityEventWrapper;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edison Xu on 2016/12/28.
 */
@FeignClient(value = "product-service")
public interface ProductService {

    @RequestMapping(method = RequestMethod.POST, value = "/product")
    public void createProduct(@RequestBody Product product);

    @RequestMapping(method = RequestMethod.PUT, value = "/product/{id}")
    public void updateProduct(@PathVariable(value = "id") long id, @RequestBody Product product);

    @RequestMapping(method = RequestMethod.PATCH, value = "/product/inventory")
    public void updateInventory(@RequestBody QuantityEventWrapper event);

    @RequestMapping(method = RequestMethod.GET, value = "/product/{id}")
    public Product getProduct(@PathVariable(value = "id") long id);

    @RequestMapping(method = RequestMethod.GET, value = "/product")
    public List<Product> getProducts();

    @RequestMapping(method = RequestMethod.DELETE, value = "/product/{id}")
    public void deleteProduct(@PathVariable(value = "id") long id);

}
