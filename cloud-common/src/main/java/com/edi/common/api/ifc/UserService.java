package com.edi.common.api.ifc;

import com.edi.common.domain.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Edison Xu on 2016/12/26.
 */
@FeignClient(value = "user-service")
@RequestMapping("/user")
public interface UserService {

    @RequestMapping(method = RequestMethod.POST)
    public void createUser();

    @RequestMapping(method = RequestMethod.PUT)
    public void updateUser(@RequestParam User user);

    @RequestMapping(method = RequestMethod.GET)
    public User getUser(@RequestParam long id);

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteUser();

}
