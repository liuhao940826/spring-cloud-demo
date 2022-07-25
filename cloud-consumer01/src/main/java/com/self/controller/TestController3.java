package com.self.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.self.bean.Depart;
import com.self.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/consumer/depart3")
public class TestController3 {

    @Autowired
    DepartService service;


    @HystrixCommand(fallbackMethod = "getFallBack",
    commandProperties = @HystrixProperty(name ="execution.isolation.thread.timeoutInMilliseconds" ,value ="2000" ))
    @GetMapping("/list3")
    public List<Depart> listHandle() {
        return service.listHandle();
    }


    public List<Depart> getFallBack(){

        Depart depart = new Depart();
        depart.setId(1);
        depart.setName("fallback");

        return Arrays.asList(depart);
    }


}
