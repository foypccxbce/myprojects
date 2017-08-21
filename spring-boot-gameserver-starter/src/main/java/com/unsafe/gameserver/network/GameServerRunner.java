package com.unsafe.gameserver.network;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Package: com.unsafe.gameserver.network
 * @Author: tangkj
 * @Daet: 2017/8/15 16:13
 * @Email: none@mail.com
 * @Desc:
 */
@Component
@Order(0x03)
public class GameServerRunner implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(GameServerRunner.class);

    @Autowired
    GameServerService serverService;

    @Override
    public void run(String... args) {
        logger.debug("Game server start.");
        serverService.startServer();
    }
}
