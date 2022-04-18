package com.example.tank.client.net.handle;

import com.alibaba.fastjson.JSONObject;
import com.example.tank.client.net.ClientContext;
import com.example.tank.common.mode.Tank;
import com.example.tank.common.msg.AbsMsg;
import com.example.tank.common.msg.LoginMsg;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author yc
 * @date 2022/4/18 9:55
 */
@Component
public class ClientHandler extends SimpleChannelInboundHandler<AbsMsg> {
    private static final Logger logger= LoggerFactory.getLogger(ClientHandler.class);
    @Resource
    private ClientContext clientContext;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.info("channel Active!");
        Tank tank = new Tank();
        tank.setUuid(UUID.randomUUID());
        tank.setTeam("team1");
        clientContext.setTank(tank);
        LoginMsg loginMsg = new LoginMsg(tank);
        clientContext.send(loginMsg);
        ctx.writeAndFlush(loginMsg);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, AbsMsg msg) throws Exception {
        logger.info("client listen msg:{}", JSONObject.toJSONString(msg));
        msg.handle();
    }
}
