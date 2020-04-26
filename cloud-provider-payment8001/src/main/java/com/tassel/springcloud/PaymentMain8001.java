package com.tassel.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
//eureka 的客户端
@EnableEurekaClient
public class PaymentMain8001 {
    public static void main(String[] agrs){
        SpringApplication.run(PaymentMain8001.class,agrs);
    }
}
