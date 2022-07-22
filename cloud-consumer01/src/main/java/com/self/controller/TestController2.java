package com.self.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.self.bean.Depart;
import com.self.config.FilterUrlConfiguration;
import com.self.service.DepartService;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.Request;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/consumer/depart2")
public class TestController2 {

    @Autowired
    DepartService service;


    @HystrixCommand(fallbackMethod = "getFallBack")
    @GetMapping("/list2")
    public List<Depart> listHandle() {
        return service.listHandle();
    }


    public List<Depart> getFallBack(){

        Depart depart = new Depart();
        depart.setId(1);
        depart.setName("fallback");

        return Arrays.asList(depart);
    }

    public static void main(String[] args) {

        BigDecimal priceExclTax = new BigDecimal(849.56);
        BigDecimal taxAmount= new BigDecimal(110.44);

        BigDecimal divide = taxAmount.divide(priceExclTax, 2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));


        DecimalFormat df = new DecimalFormat("0.0000");

        System.out.println(df.format(divide).toString());

    }

}
