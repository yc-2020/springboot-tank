package com.example.tank.client.net;

import com.example.tank.client.net.handle.ClientChannelInitializer;
import com.example.tank.common.config.TankConfig;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author yc
 * @date 2022/4/16 14:23
 */
@Component
public class TankClient {
    private static final Logger logger = LoggerFactory.getLogger(TankClient.class);

    @Resource
    private ClientChannelInitializer clientChannelInitializer;

    @Resource
    private TankConfig tankConfig;

    @Resource
    private ClientContext clientContext;

    private ChannelFuture cf = null;

    @Async
    public void connect() {
        EventLoopGroup group = new NioEventLoopGroup(1);

        Bootstrap b = new Bootstrap();

        try {
            cf = b.group(group).channel(NioSocketChannel.class).handler(clientChannelInitializer)
                    .connect(tankConfig.getServer().getAddress(), tankConfig.getServer().getPort());

            cf.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    if (!future.isSuccess()) {
                        logger.info("not connected!");
                    }
                    else {
                        logger.info("connected success");
                        // initialize the channel
                        clientContext.setChannel(future.channel());
                    }
                }
            });

            cf.sync();
            cf.channel().closeFuture().sync();
            logger.info("connection closed!");
        } catch (Exception e) {
            logger.info("tanClient connect error", e);
        } finally {
            group.shutdownGracefully();
        }
    }


    public ChannelFuture getCf() {
        return cf;
    }

    public void setCf(ChannelFuture cf) {
        this.cf = cf;
    }
}
