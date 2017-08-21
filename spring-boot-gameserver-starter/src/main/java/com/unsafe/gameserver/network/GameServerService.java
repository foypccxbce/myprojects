package com.unsafe.gameserver.network;

import com.unsafe.gameserver.network.codec.GameProtoDecoder;
import com.unsafe.gameserver.network.codec.GameProtoEncoder;
import com.unsafe.gameserver.network.handler.GameHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @Package: com.unsafe.gameserver.network
 * @Author: tangkj
 * @Daet: 2017/8/15 14:20
 * @Email: none@mail.com
 * @Desc:
 */
public class GameServerService {

    private static final Logger logger = LoggerFactory.getLogger(GameServerService.class);

    private int gamePort = 8000;

    public void setGamePort(int gamePort) {
        this.gamePort = gamePort;
    }

    void startServer() {
        EventLoopGroup p = new NioEventLoopGroup(1);
        EventLoopGroup c = new NioEventLoopGroup();
        ServerBootstrap b = new ServerBootstrap();
        b.group(p, c)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_RCVBUF, 32 * 1024)
                .option(ChannelOption.SO_RCVBUF, 32 * 1024)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .handler(new LoggingHandler(LogLevel.DEBUG))
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) {
                        ChannelPipeline p = ch.pipeline();
                        p.addLast(new IdleStateHandler(10, 10, 10, TimeUnit.SECONDS));
                        p.addLast(new GameProtoDecoder());
                        p.addLast(new GameHandler());
                        p.addLast(new GameProtoEncoder());
                    }
                });
        try {
            ChannelFuture f = b.bind(gamePort).sync();
            f.channel().closeFuture().sync();
        } catch (Exception e) {
            logger.error("Game server start error," + e.getMessage());
        } finally {
            p.shutdownGracefully();
            c.shutdownGracefully();
        }
    }
}
