package com.edi;

import com.edi.api.ifc.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Edison Xu on 2016/12/19.
 */

@RestController
public class ApiGateway {

    @Autowired
    private EchoService echoService;

    @RequestMapping(method=RequestMethod.POST, value="/echolb")
    public String echo(@RequestBody String name){
        return echoService.echoj(name);
    }

}
