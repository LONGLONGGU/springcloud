package com.pie.springcloud.controller;

import com.pie.springcloud.model.CommonResult;
import com.pie.springcloud.model.Payment;
import com.pie.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @ Author     ：longlong
 * @ Date       ：Created in 15:47 2021/4/7
 */
@RestController
@RequestMapping("payment")
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "create")
    public CommonResult create(@RequestBody Payment payment){
      int result =  paymentService.create(payment);
      log.info("插入结果"+result);
      if (result >0 ){
          return new CommonResult(200,"插入数据库成功",result);
      }
        return new CommonResult(500,"插入数据库失败");
    }

    @GetMapping(value = "get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        System.out.print("服务："+serverPort);
        Payment payment = paymentService.getPaymentById(id);
        if (payment!=null){
            return new CommonResult(200,"查询成功：服务："+serverPort,payment);
        }
        return new CommonResult(500,"查询失败");
    }

    @GetMapping(value = "discovery")
    public  Object discovery(){
     List<String> lists = discoveryClient.getServices();
     for (String element: lists){
         System.out.print(element);
     }
     List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
     for (ServiceInstance instance:instances){
         log.info(instance.getServiceId()+"/t"+instance.getHost()+"/t"+instance.getPort()+"/t"+instance.getUri());
     }
     return this.discoveryClient;
    }


}
