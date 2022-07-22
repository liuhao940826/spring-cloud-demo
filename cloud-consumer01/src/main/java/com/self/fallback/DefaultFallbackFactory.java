package com.self.fallback;

import com.self.bean.Depart;
import com.self.service.DepartService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @Classname DefaultFallbackFactory
 * @Description TODO
 * @Date 2021/8/5 下午4:20
 * @Created by liuhao
 */
@Component
public class DefaultFallbackFactory implements FallbackFactory<DepartService> {

    /**
     * 这个是服务在 消费者这里指定的降级的方法 真的实现在服务那边
     * @param throwable
     * @return
     */
    @Override
    public DepartService create(Throwable throwable) {
        return new DepartService() {
            @Override
            public List<Depart> listHandle() {

                System.out.println("我是被降级的  类");

                Depart depart = new Depart();
                depart.setId(1);
                depart.setName("我是被降级的  类");


                return Arrays.asList(depart);
            }

        };
    }
}
