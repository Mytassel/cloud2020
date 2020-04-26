package com.tassel.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain803 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain803.class,args);
    }

}
