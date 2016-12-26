package com.edi;

import com.edi.common.api.ifc.UserService;
import com.edi.common.domain.User;
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
public class UserController implements UserService {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private DiscoveryClient client;

    @Override
    public void createUser() {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("create user. host:" + instance.getHost() + ", service_id:" + instance.getServiceId());

    }

    @Override
    public void updateUser(@RequestParam User user) {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("update user. host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
    }

    @Override
    public User getUser(@RequestParam long id) {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("query user. host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
        return null;
    }

    @Override
    public void deleteUser() {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("delete user. host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
    }
}
