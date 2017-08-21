package com.unsafe.gameserver.network.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * @Package: com.unsafe.gameserver.network.codec
 * @Author: tangkj
 * @Daet: 2017/8/15 16:45
 * @Email: none@mail.com
 * @Desc:
 */
public class GameProtoEncoder extends MessageToMessageEncoder<ByteBuf> {
    @Override
    protected void encode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) {

    }
}
