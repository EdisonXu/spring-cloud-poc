package com.edi;

import com.edi.api.ifc.EchoService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by Edison Xu on 2016/12/20.
 */
@Component
public class EchoServiceHystrix implements EchoService {

    @Override
    public String echoj(@RequestBody String name) {
        return "The service is not available at this time!";
    }
}
