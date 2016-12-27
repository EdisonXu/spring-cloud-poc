package com.edi.api.ifc;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by Edison Xu on 2016/12/27.
 */
@FeignClient("user-service")
public interface UserServiceClient {
}
