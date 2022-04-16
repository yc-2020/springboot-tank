package com.example.tank.server.net;

import com.example.tank.server.config.TankConfig;
import com.example.tank.server.net.childHandler.ServerChildHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author yc
 * @date 2022/4/16 10:23
 */
@Component
public class TankServer {

    private static final Logger logger = LoggerFactory.getLogger(TankServer.class);
    @Resource
    private TankConfig tankConfig;

    @Async
    public void serverStart() {
        EventLoopGroup boosGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        try {
            ChannelFuture future = bootstrap.group(boosGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer() {
                        @Override
                        protected void initChannel(Channel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new ServerChildHandler());
                        }

                        @Override
                        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
                            logger.error("server error",cause);
                        }
                    })
                    .bind(tankConfig.getServer().getPort())
                    .sync();
            logger.info("tank server start");
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            logger.error("tank server start error", e);
        } finally {
            workerGroup.shutdownGracefully();
            boosGroup.shutdownGracefully();
        }
    }
}