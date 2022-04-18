package com.example.tank.client.net;

import com.alibaba.fastjson.JSONObject;
import com.example.tank.common.mode.Tank;
import com.example.tank.common.msg.AbsMsg;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author yc
 * @date 2022/4/18 9:21
*/
@Component
public class ClientContext {
    private static final Logger logger= LoggerFactory.getLogger(ClientContext.class);

    private Channel channel;

    private Tank tank;


    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
    public void send(AbsMsg msg) {
        logger.info("SEND:{}", JSONObject.toJSONString(msg));
        channel.writeAndFlush(msg);
    }

    public static Logger getLogger() {
        return logger;
    }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }
}
