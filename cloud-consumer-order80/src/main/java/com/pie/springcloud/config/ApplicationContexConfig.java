package com.pie.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ Author     ：longlong
 * @ Date       ：Created in 14:35 2021/4/8
 */
@Configuration
public class ApplicationContexConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){

        return new RestTemplate();
    }
}
//bean  相当于 applicationContex.xml <bean id="" class=""/>