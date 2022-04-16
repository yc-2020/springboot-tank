package com.example.tank.server.net.childHandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author yc
 * @date 2022/4/16 11:52
*/

public class ServerChildHandler extends ChannelInboundHandlerAdapter {
    private static Logger logger= LoggerFactory.getLogger(ServerChildHandler.class);
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        byte[] bytes=new byte[byteBuf.readableBytes()];
        byteBuf.getBytes(0,bytes);
        logger.info("服务器接收到的消息:{}",new String(bytes));
    }
}
