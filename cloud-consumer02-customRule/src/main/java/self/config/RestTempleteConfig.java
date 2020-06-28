package self.config;

import com.netflix.loadbalancer.IRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Configuration
public class RestTempleteConfig {

    // 开启负载均衡，为了让负载均衡器完成
    // 从服务名称到主机的映射
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    @Bean
    public IRule loadBalanceRule(){
        return  new CustomRuleConfig(Arrays.asList(8081));
    }

}
