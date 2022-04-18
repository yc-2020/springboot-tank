package com.example.tank.client.ui;

import com.example.tank.client.config.ClientConfig;
import com.example.tank.client.net.ClientContext;
import com.example.tank.client.ui.keyListener.TankKeyListener;
import com.example.tank.client.net.TankClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.expression.spel.CodeFlow;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author yc
 * @date 2022/4/16 15:54
 */
@Component
public class GameFrame extends Frame {
    private static final Logger logger = LogManager.getLogger(GameFrame.class);

    /**
     * 配置文件，又构造方法注入
     */
    private ClientConfig clientConfig;


    private TankClient tankClient;

    private ClientContext clientContext;



    public GameFrame(ClientConfig clientConfig,TankKeyListener tankKeyListener,TankClient tankClient,ClientContext clientContext) {
        this.clientConfig=clientConfig;
        this.setSize(clientConfig.getSize().getWight(), clientConfig.getSize().getHeight());
        this.setResizable(false);
        this.setBackground(Color.BLACK);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if(null!=tankClient.getCf()){
                    clientContext.getChannel().close();
                }
                System.exit(0);
            }
        });
        this.addKeyListener(tankKeyListener);
        this.tankClient=tankClient;
    }

}
