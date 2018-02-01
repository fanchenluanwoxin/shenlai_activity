package com.mange.activity.dubbo.imp;

import com.alibaba.dubbo.config.annotation.Service;
import com.mange.activity.dubbo.HellowService;

/**
 * Create by lbm on 2017/11/10
 *
 * @author lbm
 */
@Service(version = "1.0.0")
public class HellowServiceImp implements HellowService {
    @Override
    public String hellow(String name) {
        return "hellow "+name+" from activity dubbo service !";
    }
}
