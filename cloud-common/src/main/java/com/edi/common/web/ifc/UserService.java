package com.edi.common.web.ifc;

import com.edi.common.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Edison Xu on 2016/12/27.
 */
public interface UserService {

    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public void createUser(@RequestBody User user);

    @RequestMapping(method = RequestMethod.PUT, value = "/user/{id}")
    public void updateUser(@PathVariable long id, @RequestBody User user);

    @RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
    public User getUser(@PathVariable long id);

    @RequestMapping(method = RequestMethod.GET, value = "/user")
    public List<User> getUsers();

    @RequestMapping(method = RequestMethod.DELETE, value = "/user/{id}")
    public void deleteUser(@PathVariable long id);

}