package com.example.tank.client.config;

import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author yc
 * @date 2022/4/16 15:56
*/
@Reference
@Component
@ConfigurationProperties(prefix = "tank.client")
public class ClientConfig {

    private Size size;

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public static class Size{
        private Integer wight;
        private Integer height;

        public Integer getWight() {
            return wight;
        }

        public void setWight(Integer wight) {
            this.wight = wight;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }
    }

}
