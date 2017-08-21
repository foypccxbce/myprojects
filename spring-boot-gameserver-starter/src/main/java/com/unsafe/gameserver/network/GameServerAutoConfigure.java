package com.unsafe.gameserver.network;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Package: com.unsafe.gameserver.network
 * @Author: tangkj
 * @Daet: 2017/8/15 14:21
 * @Email: none@mail.com
 * @Desc:
 */

@Configuration
@ConditionalOnClass(GameServerService.class)
@EnableConfigurationProperties(GameServerProperties.class)
public class GameServerAutoConfigure {

    @Autowired
    private GameServerProperties gameServerProperties;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "unsafe.gs", value = "enabled", havingValue = "true")
    GameServerService gameServerService() {
        GameServerService service = new GameServerService();
        service.setGamePort(gameServerProperties.getGamePort());
        return service;
    }
}
