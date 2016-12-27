package com.edi.services.web.controllers;

import com.edi.common.domain.CommandEvent;
import com.edi.common.domain.User;
import com.edi.common.utils.AggregatorIdGenerator;
import com.edi.common.web.ifc.UserService;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Edison Xu on 2016/12/15.
 */
@RestController
public class UserController implements UserService {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private SqlSession sqlSession;

    @Autowired
    private DiscoveryClient client;

    @Autowired
    private HttpServletRequest request;

    @Override
    public void createUser(@RequestBody User user) {
        logInstanceInfor();
        user.setAggId(AggregatorIdGenerator.instance.getId());
        user.setEvent(CommandEvent.COMMIT);
        sqlSession.insert("com.edi.services.mapper.UserMapper.insertUser",user);
    }

    @Override
    public void updateUser(@PathVariable long id, @RequestBody User user) {
        logInstanceInfor();
        user.setAggId(AggregatorIdGenerator.instance.getId());
        user.setEvent(CommandEvent.COMMIT);
        //this.sqlSession.update("updateUser", user);
        this.sqlSession.insert("insertUser", user);
    }

    @Override
    public User getUser(@PathVariable long id) {
        logInstanceInfor();
        User u = new User(id);
        u.setEvent(CommandEvent.COMMIT);
        return sqlSession.selectOne("readUser", u);
    }

    @Override
    public void deleteUser(@PathVariable long id) {
        logInstanceInfor();
        this.sqlSession.delete("deleteUser",id);
    }

    private void logInstanceInfor() {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info(request.getMethod()+":" + request.getRequestURL()+ ", host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
    }
}
