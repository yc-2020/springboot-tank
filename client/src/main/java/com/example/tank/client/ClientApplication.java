package com.example.tank.client;

import com.example.tank.client.config.ClientConfig;
import com.example.tank.client.ui.GameFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

/**
 * @author yc
 */
@SpringBootApplication
public class ClientApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(ClientApplication.class);

    @Resource
    private GameFrame gameFrame;

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        gameFrame.setVisible(true);
    }
}
