package cn.itcast.order.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * className DefaultFeignConfiguration
 * packageName cn.itcast.order.config
 * Description DefaultFeignConfiguration Feign log 的配置类文件
 *
 * @author huian
 * @version 1.0
 * @Date: 2023/8/9 20:46
 */
public class DefaultFeignConfiguration {
    @Bean
    public Logger.Level logLevel() {
        return Logger.Level.BASIC;
    }
}
