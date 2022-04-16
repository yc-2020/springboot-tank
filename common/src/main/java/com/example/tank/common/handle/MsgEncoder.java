package com.example.tank.common.handle;

import com.example.tank.common.msg.AbsMsg;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author yc
 * @date 2022/4/16 14:27
*/
public class MsgEncoder extends MessageToByteEncoder<AbsMsg> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, AbsMsg absMsg, ByteBuf byteBuf) throws Exception {
        byteBuf.writeInt(absMsg.getMsgType().ordinal());
        byte[] bytes = absMsg.toBytes();
        byteBuf.writeInt(bytes.length);
        byteBuf.writeBytes(bytes);
    }
}
