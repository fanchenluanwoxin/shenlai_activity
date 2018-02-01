package com.mange.activity;

import com.mange.activity.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author lbm
 */
@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties({User.class})
public class ShenlaiActivityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShenlaiActivityApplication.class, args);
	}
}
