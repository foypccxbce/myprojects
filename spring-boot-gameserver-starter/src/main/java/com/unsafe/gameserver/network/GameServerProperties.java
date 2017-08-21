package com.unsafe.gameserver.network;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Package: com.unsafe.gameserver.network
 * @Author: tangkj
 * @Daet: 2017/8/15 14:20
 * @Email: none@mail.com
 * @Desc:
 */
@Getter
@Setter
@Component
@ConfigurationProperties("unsafe.gs")
public class GameServerProperties {
    private int gamePort;
    private int managePort;
    private int webAppPort;
}
