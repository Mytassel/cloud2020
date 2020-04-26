package com.tassel.springcloud.controller;

import com.tassel.springcloud.entities.CommonResult;
import com.tassel.springcloud.entities.Payment;
import com.tassel.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    //只传给前端CommonResult，不需要前端了解其他的组件
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        log.info("得到结果："+payment.getSerial());
        int result = paymentService.create(payment);
        log.info("*****插入结果："+result);
        if(result > 0){
            return new CommonResult(200,"插入数据成功 serverPort:"+serverPort,result);
        }else{
            return new CommonResult(444,"插入数据失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****插入结果："+payment);
        if(payment != null){
            return new CommonResult(200,"查询成功serverPort:"+serverPort,payment);
        }else{
            return new CommonResult(444,"没有对应记录,查询ID："+id,null);
        }
    }


    @GetMapping(value = "/payment/discovery")
    public Object getDiscoveryClient(){
        //遍历discoveryClient信息
        List<String> services = discoveryClient.getServices();
        for (int i = 0; i < services.size(); i++) {
            String s =  services.get(i);
            log.info("service: "+s);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (int i = 0; i < instances.size(); i++) {
            ServiceInstance serviceInstance =  instances.get(i);
            log.info("ServiceId : "+serviceInstance.getServiceId());
            log.info("Port : "+serviceInstance.getPort());
            log.info("Host : "+serviceInstance.getHost());
            log.info("Uri : "+serviceInstance.getUri());
        }
        return  this.discoveryClient;
    }

}
