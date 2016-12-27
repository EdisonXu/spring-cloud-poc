package com.edi.services.web.controller;

import com.edi.com.edi.services.web.ifc.EchoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Edison Xu on 2016/12/15.
 */
@RestController
@RequestMapping(value = "/")
public class EchoController  implements EchoService {

    private final Logger logger = LoggerFactory.getLogger(EchoController.class);

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(method={RequestMethod.GET,RequestMethod.POST}, value="/echo/{id}")
    public String echo(@PathVariable String id){
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
        return id;
    }

    @RequestMapping("/echoj")
    public String echoj(@RequestBody String name){
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
        return name;
    }

}
