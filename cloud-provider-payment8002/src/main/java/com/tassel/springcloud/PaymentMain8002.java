package com.tassel.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//eureka 的客户端
@EnableEurekaClient
public class PaymentMain8002 {
    public static void main(String[] agrs){
        SpringApplication.run(PaymentMain8002.class,agrs);
    }

}
