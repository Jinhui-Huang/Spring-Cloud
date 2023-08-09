package cn.itcast.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * className PatternProperties
 * packageName cn.itcast.user.config
 * Description PatternProperties
 *
 * @author huian
 * @version 1.0
 * @Date: 2023/8/9 13:38
 */

@Data
@Component
@ConfigurationProperties(prefix = "pattern")
public class PatternProperties {
    private String dateformat;
    private String envSharedValue;
}
