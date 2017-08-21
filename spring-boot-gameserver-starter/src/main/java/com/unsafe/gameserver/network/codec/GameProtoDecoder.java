package com.unsafe.gameserver.network.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

/**
 * @Package: com.unsafe.gameserver.network.codec
 * @Author: tangkj
 * @Daet: 2017/8/15 16:45
 * @Email: none@mail.com
 * @Desc: ---
 * +-------------------------------------------------+
 * | Game Proto Desc.                                |
 * |-------------------------------------------------|
 * | First Byte | Second byte | desc: Message Length |
 * |-------------------------------------------------|
 * | Three Byte | desc: Main MessageCode             |
 * |-------------------------------------------------|
 * | Four Byte  | desc:  Sub MessageCode             |
 * |-------------------------------------------------|
 * | Five Byte  | desc:  Retain Message              |
 * |-------------------------------------------------|
 * | Body Bytes                                      |
 * +-------------------------------------------------+
 */
public class GameProtoDecoder extends MessageToMessageDecoder<ByteBuf> {
    private static final int MESSAGE_MIN_SIZE = 0x04;

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
        while (in.readableBytes() > MESSAGE_MIN_SIZE) {
            byte low = in.readByte();
            byte high = in.readByte();
            short s0 = (short) (low & 0xff);
            short s1 = (short) (high & 0xff);
            s1 <<= 8;
            short messageLength = (short) (s0 | s1);
            byte mainCode = in.readByte();
            byte subCode = in.readByte();
            byte retain = in.readByte();
            if (in.readableBytes() < messageLength) {
                in.resetReaderIndex();
                return;
            }
        }
    }
}
