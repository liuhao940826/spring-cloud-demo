package self.config;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author alan.liu
 * @Discription
 * @date 2019-06-13 10:45
 */
public class CustomRuleConfig implements IRule {

    private ILoadBalancer loadBalancer;

    private List<Integer> postList;

    @Override
    public Server choose(Object o) {
        //获取所有可用的服务器列表
        List<Server> reachableServers = loadBalancer.getReachableServers();
        //获取可以访问的服务集合
        List<Server> availableServers = availableServers(reachableServers);
        //返回具体某一个服务
        return this.getRandomRuleServer(availableServers);
    }

    /**
     * 为对应的某一个服务设置对应的负载均衡的的规则
     *
     * @param availableServers
     * @return
     */
    private Server getRandomRuleServer(List<Server> availableServers) {
        return availableServers.get(new Random().nextInt(availableServers.size()));
    }

    /**
     * 初始化负载均衡器
     *
     * @param iLoadBalancer
     */
    @Override
    public void setLoadBalancer(ILoadBalancer iLoadBalancer) {
        loadBalancer = iLoadBalancer;
    }

    /**
     * 获取负载均衡器
     *
     * @return
     */
    @Override
    public ILoadBalancer getLoadBalancer() {
        return loadBalancer;
    }


    /**
     * 获取可执行的服务列表
     *
     * @param reachableServers
     * @return
     */
    public List<Server> availableServers(List<Server> reachableServers) {

        if (CollectionUtils.isEmpty(reachableServers)) {
            return reachableServers;
        }

        //最终可以访问的服务集合
        List<Server> availableServers = new ArrayList<>();

        for (Server server : reachableServers) {

            boolean flag = true;

            for (Integer port : postList) {

                if (Integer.valueOf(server.getPort()) == port) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                availableServers.add(server);
            }

        }
        //返回最终的可以访问的服务集合对象
        return availableServers;
    }

    public List<Integer> getPostList() {
        return postList;
    }

    public void setPostList(List<Integer> postList) {
        this.postList = postList;
    }

    public CustomRuleConfig() {
    }

    public CustomRuleConfig(List<Integer> postList) {
        this.postList = postList;
    }
}
