package com.self.service;

import com.self.bean.Depart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Classname DepartService
 * @Description TODO
 * @Date 2021/8/4 下午7:26
 * @Created by liuhao
 */
//指定当前的fegin客户端 参数为提供服务的服务名application-name
//DpearService 和方法名一般是相同 但是可以不同
//mapping和参数 返回值必须相同
@FeignClient("alan-provider-8081")
@RequestMapping("/provider/depart")
public interface DepartService {

    @GetMapping("/list")
    public List<Depart> listHandle();

}
