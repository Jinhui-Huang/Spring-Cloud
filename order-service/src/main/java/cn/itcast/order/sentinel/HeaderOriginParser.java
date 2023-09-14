package cn.itcast.order.sentinel;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import com.alibaba.nacos.api.utils.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Description: HeaderOriginParser
 * <br></br>
 * className: HeaderOriginParser
 * <br></br>
 * packageName: cn.itcast.order.sentinel
 *
 * @author jinhui-huang
 * @version 1.0
 * @email 2634692718@qq.com
 * @Date: 2023/9/12 19:45
 */
@Component
public class HeaderOriginParser implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        /*1.获取请求头*/
        String origin = httpServletRequest.getHeader("origin");
        /*2.非空判断*/
        if (StringUtils.isEmpty(origin)) {
            origin = "blank";
        }
        return origin;
    }
}
