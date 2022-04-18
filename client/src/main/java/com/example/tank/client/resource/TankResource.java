package com.example.tank.client.resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author yc
 * @date 2022/4/13 14:45
 */
public class TankResource {
    private static final Logger logger = LogManager.getLogger(TankResource.class);
    public static BufferedImage tankU, tankD, tankL, tankR;

    static {
        try {
            tankU = ImageIO.read(TankResource.class.getResourceAsStream("/image/tank/tankU.gif"));
            tankD = ImageIO.read(TankResource.class.getResourceAsStream("/image/tank/tankD.gif"));
            tankL = ImageIO.read(TankResource.class.getResourceAsStream("/image/tank/tankL.gif"));
            tankR = ImageIO.read(TankResource.class.getResourceAsStream("/image/tank/tankR.gif"));
        } catch (IOException e) {
            logger.error("加载坦克资源失败", e);
        }
    }
}
