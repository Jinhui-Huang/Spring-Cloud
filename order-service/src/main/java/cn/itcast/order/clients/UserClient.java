package cn.itcast.order.clients;

import cn.itcast.order.config.DefaultFeignConfiguration;
import cn.itcast.order.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * className UserClient
 * packageName cn.itcast.order.clients
 * Description UserClient Feign客户端接口
 *
 * @author huian
 * @version 1.0
 * @Date: 2023/8/9 20:20
 */
@FeignClient("userservice")
public interface UserClient {

    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);
}
