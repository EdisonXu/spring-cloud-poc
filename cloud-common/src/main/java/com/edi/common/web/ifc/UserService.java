package com.edi.common.web.ifc;

import com.edi.common.domain.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Edison Xu on 2016/12/27.
 */
@FeignClient(value = "user-service")
public interface UserService {

    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public void createUser(@RequestBody User user);

    @RequestMapping(method = RequestMethod.PUT, value = "/user/{id}")
    public void updateUser(@PathVariable(value = "id") long id, @RequestBody User user);

    @RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
    public User getUser(@PathVariable(value = "id") long id);

    @RequestMapping(method = RequestMethod.GET, value = "/user")
    public List<User> getUsers();

    @RequestMapping(method = RequestMethod.DELETE, value = "/user/{id}")
    public void deleteUser(@PathVariable(value = "id") long id);

}