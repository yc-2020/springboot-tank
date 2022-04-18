package com.example.tank.common.handle;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import org.springframework.stereotype.Component;


@Component
public class ClientChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline()
                .addLast(new MsgEncoder())
                .addLast(new MsgDecoder())
                .addLast(new ClientHandler());
    }
}
