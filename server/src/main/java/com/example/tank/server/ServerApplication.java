package com.example.tank.server;

import com.alibaba.fastjson.JSONObject;
import com.example.tank.server.net.TankServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.annotation.Resource;

/**
 * @author yc
 */
@EnableAsync
@SpringBootApplication
public class ServerApplication implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(ServerApplication.class);

    @Resource
    private TankServer tankServer;

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        tankServer.serverStart();
    }
}
