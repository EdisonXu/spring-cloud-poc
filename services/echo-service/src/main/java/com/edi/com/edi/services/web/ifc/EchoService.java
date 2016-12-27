package com.edi.com.edi.services.web.ifc;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Edison Xu on 2016/12/18.
 */
@FeignClient("echo-service")
public interface EchoService {

    @RequestMapping(method=RequestMethod.POST, value="/echoj")
    public String echoj(@RequestBody String name);
}
