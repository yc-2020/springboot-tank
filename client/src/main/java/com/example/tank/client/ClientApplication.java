package com.example.tank.client;

import com.alibaba.fastjson.JSONObject;
import com.example.tank.client.config.ClientConfig;
import com.example.tank.client.net.TankClient;
import com.example.tank.client.ui.GameFrame;
import com.example.tank.common.config.TankConfig;
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
@SpringBootApplication(scanBasePackages="com.example.tank")
public class ClientApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(ClientApplication.class);

    @Resource
    private GameFrame gameFrame;

    @Resource
    private TankClient tankClient;

    @Resource
    private TankConfig tankConfig;

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("tankConfig{}", JSONObject.toJSONString(tankConfig));
        tankClient.connect();
        gameFrame.setVisible(true);
    }

}
