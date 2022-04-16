package com.example.tank.server.config;

import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author yc
 * @date 2022/4/16 10:26
 */
@Reference
@Component
@ConfigurationProperties(prefix = "tank")
public class TankConfig {

    private Server server;

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public static class Server {
        private Integer port;

        public Integer getPort() {
            return port;
        }

        public void setPort(Integer port) {
            this.port = port;
        }
    }
}
