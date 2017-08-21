package com.unsafe.gameserver.core.session;

import io.netty.channel.nio.AbstractNioChannel;

/**
 * @Package: com.unsafe.gameserver.core.session
 * @Author: tangkj
 * @Daet: 2017/8/21 17:51
 * @Email: none@mail.com
 * @Desc:
 */
public class Session {
    AbstractNioChannel channel;
    IGamePlayer player;

    public void onConnection(AbstractNioChannel channel) {
        this.channel = channel;
    }

    public void onPlayerLoginSuccess(IGamePlayer player) {
        this.player = player;
    }
}
