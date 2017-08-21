package com.myprojects;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Package: com.myprojects
 * @Author: tangkj
 * @Daet: 2017/8/7 14:35
 * @Email: none@mail.com
 * @Desc:
 */

@Getter
@Setter

@ConfigurationProperties(prefix = "spring.netty")
public class NettyConfigure {
    private int serverPort;
}
