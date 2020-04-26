package com.tassel.springcloud.controller;

import com.tassel.springcloud.entities.CommonResult;
import com.tassel.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    //private static final String PAYMENT_URL="http://localhost:8001";

    //通过在eureka上注册过的微服务名称调用
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    /**postForObject 对象
     * postForEntity 具体信息
     *
     * getForObject
     * getForEntity
     *
     * @param payment
     * @return
     */

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
//        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
        return restTemplate.postForEntity(PAYMENT_URL+"/payment/create",payment,CommonResult.class).getBody();
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
//        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
        ResponseEntity<CommonResult> template = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if(template.getStatusCode().is2xxSuccessful()){
            return template.getBody();
        }else{
            return new CommonResult(444,"服务出错。");
        }

    }

}
