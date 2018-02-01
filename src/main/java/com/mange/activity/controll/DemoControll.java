package com.mange.activity.controll;

import com.fasterxml.jackson.annotation.JsonView;
import com.mange.activity.domain.Table;
import com.mange.activity.domain.User;
import com.mange.activity.feign.FeignDemo;
import com.mange.activity.vo.ModelView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by lbm on 2017/11/10
 *
 * @author lbm
 */
@RestController
public class DemoControll {
    @Value("${com.mange.activity.name}")
    private String activity;
    @Autowired
    User user;
    @Autowired
    FeignDemo feignDemo;

    @RequestMapping("/hellow")
    public String hellow(String name){
        return "hellow "+name+" for"+activity+" !";
    }

    @RequestMapping("/hi")
    @JsonView(ModelView.User.class)
    public User hi(){
        return user;
    }

    @RequestMapping("/hiAll")
    @JsonView(ModelView.UserAll.class)
    public User hiAll(){
        return user;
    }

    @RequestMapping("/build")
    @JsonView(ModelView.Table.class)
    public Table build(){
        Table table = Table.builder().id(1L).tableName("table1").build();
        return table;
    }

    @RequestMapping("/feignHellow")
    public String feignHellow(String name){
        return feignDemo.hellowClient(name);
    }
}
