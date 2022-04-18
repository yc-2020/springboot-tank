package com.example.tank.common.handle;

import com.alibaba.fastjson.JSONObject;
import com.example.tank.common.msg.AbsMsg;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class ClientHandler extends SimpleChannelInboundHandler<AbsMsg> {

    private static final Logger logger= LoggerFactory.getLogger(ClientHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, AbsMsg msg) throws Exception {
        logger.info("接受到的消息{}", JSONObject.toJSONString(msg));
        msg.handle();
    }

    /**
     * 登录
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        ctx.writeAndFlush(new TankJoinMsg(TankFrame.INSTANCE.getMainTank()));
    }
}