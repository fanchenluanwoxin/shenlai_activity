package com.mange.activity.domain;

import com.fasterxml.jackson.annotation.JsonView;
import com.mange.activity.vo.ModelView;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Create by lbm on 2017/11/10
 * @author lbm
 */
@Data
@Configuration
@PropertySource("classpath:test.properties")
@ConfigurationProperties(prefix = "my.user")
public class User {
    @JsonView(ModelView.UserAll.class)
    private Long id;
    @JsonView(ModelView.User.class)
    private String name;
    @JsonView(ModelView.User.class)
    private String sex;
    @JsonView(ModelView.User.class)
    private String desc;
}
