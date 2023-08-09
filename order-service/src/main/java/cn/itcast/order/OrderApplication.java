package cn.itcast.order;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import cn.itcast.order.config.DefaultFeignConfiguration;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@MapperScan("cn.itcast.order.mapper")
@SpringBootApplication
@EnableFeignClients(defaultConfiguration = DefaultFeignConfiguration.class)
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    /**
     * Description: 创建restTemplate并注入spring容器
     * @return org.springframework.web.client.RestTemplate
     * @author huian
     * @Date 2023/8/7
     * */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * Description: randomRule负载均衡策略中的随机数策略
     * @return com.netflix.loadbalancer.IRule
     * @author huian
     * @Date 2023/8/8
     * */
    /*@Bean
    public IRule randomRule(){
        return new RandomRule();
    }*/

}