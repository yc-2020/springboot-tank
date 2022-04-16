package com.example.tank.common.manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author yc
 * @date 2022/4/13 14:45
 */
public class TankResourceManager {
    private static final Logger logger = LogManager.getLogger(TankResourceManager.class);
    public static BufferedImage tankU, tankD, tankL, tankR;

    static {
        try {
            tankU = ImageIO.read(TankResourceManager.class.getResourceAsStream("/image/tank/tankU.gif"));
            tankD = ImageIO.read(TankResourceManager.class.getResourceAsStream("/image/tank/tankD.gif"));
            tankL = ImageIO.read(TankResourceManager.class.getResourceAsStream("/image/tank/tankL.gif"));
            tankR = ImageIO.read(TankResourceManager.class.getResourceAsStream("/image/tank/tankR.gif"));
        } catch (IOException e) {
            logger.error("加载坦克资源失败", e);
        }
    }
}
