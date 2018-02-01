package com.mange.activity.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Create by lbm on 2017/11/13
 * @author lbm
 * 如果注册中心用eureka name为注册的服务名
 * 有url则直接调用url
 */
@FeignClient(name = "feignDemo",url = "http://localhost:8080/activity")
public interface FeignDemo {
    @RequestMapping(value = "/hellow", method = RequestMethod.GET)
     String hellowClient(@RequestParam(name = "name") String name);
}
