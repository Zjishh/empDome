package com.zjh.emp.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/****************************
 * @project empservice
 * @package com.zjh.emp.utils
 * @className AliOSSproperties
 * @author Zjiah
 * @date 2023/10/10 13:18
 * @Description:   *
 ****************************/
@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss")

public class AliOSSproperties {

    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
}
