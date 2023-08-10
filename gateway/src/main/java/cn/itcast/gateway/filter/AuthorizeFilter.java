package cn.itcast.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * className AuthorizeFilter
 * packageName cn.itcast.gateway
 * Description AuthorizeFilter全局过滤器
 * # @Order(-1) 拦截器的优先级
 * @author huian
 * @version 1.0
 * @Date: 2023/8/10 11:31
 */
/*@Order(-1)*/
@Component
public class AuthorizeFilter implements GlobalFilter, Ordered {

    /**
     * Description: 定义全局过滤器, 拦截请求, 判断请求的参数是否满足下列要求:
     * 1. 参数中是否有authorization
     * 2. authorization参数值是否为admin
     * 3. 如果同时满足则放行, 否则拦截
     * @return reactor.core.publisher.Mono<java.lang.Void> 返回标示当前过滤器业务结束
     * @param exchange 请求上下文, 里面可以获取Request, Response等信息
     * @param chain 用来把请求委托给下一个过滤器
     * @author huian
     * @Date 2023/8/10
     * */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        /*1. 获取请求参数*/
        ServerHttpRequest request = exchange.getRequest();
        MultiValueMap<String, String> queryParams = request.getQueryParams();
        /*2. 获取参数中的authorization参数*/
        String auth = queryParams.getFirst("authorization");
        /*3. 判断参数值是否等于admin*/
        if ("admin".equals(auth)) {
            /*4. 是, 放行*/
            return chain.filter(exchange);
        }
        /*5. 否, 拦截*/
        /*5.1. 设置状态码*/
        exchange.getResponse().setStatusCode(HttpStatus.NOT_FOUND);
        /*5.2. 返回拦截状态*/
        return exchange.getResponse().setComplete();
    }

    /**
     * Description: getOrder与@Order(-1)同样的作用, 设置拦截器的优先级
     * @return int
     * @author huian
     * @Date 2023/8/10
     * */
    @Override
    public int getOrder() {
        return -1;
    }
}
