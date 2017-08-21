package com.myprojects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @Package: com.myprojects
 * @Author: tangkj
 * @Daet: 2017/8/7 11:48
 * @Email: none@mail.com
 * @Desc:
 */
@SpringBootApplication
@EnableConfigurationProperties({YmlConfig.class})
public class gs {
    public static void main(String[] args) {
        SpringApplication.run(gs.class);
    }
}
