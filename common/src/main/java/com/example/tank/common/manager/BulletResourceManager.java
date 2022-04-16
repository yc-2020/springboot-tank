package com.example.tank.common.manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author yc
 * @date 2022/4/13 14:51
*/
public class BulletResourceManager {
    public static BufferedImage bulletU, bulletD, bulletL, bulletR;
    private static final Logger logger= LogManager.getLogger(BulletResourceManager.class);
    static {
        try {
            bulletU = ImageIO.read(BulletResourceManager.class.getResourceAsStream("/image/bullet/bulletU.gif"));
            bulletD = ImageIO.read(BulletResourceManager.class.getResourceAsStream("/image/bullet/bulletD.gif"));
            bulletL = ImageIO.read(BulletResourceManager.class.getResourceAsStream("/image/bullet/bulletL.gif"));
            bulletR = ImageIO.read(BulletResourceManager.class.getResourceAsStream("/image/bullet/bulletR.gif"));
        } catch (IOException e) {
            logger.error("加载子弹资源失败",e);
        }
    }
}
