package com.example.tank.client.net.handle;

import com.example.tank.client.net.ClientContext;
import com.example.tank.common.handle.MsgDecoder;
import com.example.tank.common.handle.MsgEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
 * @author yc
 */
@Component
public class ClientChannelInitializer extends ChannelInitializer<SocketChannel> {
    private static final Logger logger = LoggerFactory.getLogger(ClientChannelInitializer.class);
    @Resource
    private ClientContext clientContext;
    @Resource
    private ClientHandler clientHandler;

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline()
                .addLast(new MsgEncoder())
                .addLast(new MsgDecoder())
                .addLast(clientHandler);
    }

}
