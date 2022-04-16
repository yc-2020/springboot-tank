package com.example.tank.common.manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author yc
 * @date 2022/4/13 16:32
*/
public class ExplodeResourceManager {
    private static final Logger logger= LogManager.getLogger(ExplodeResourceManager.class);
    public static BufferedImage[] bufferedImageList=new BufferedImage[16];
    static {
        try {
            for(int i=1;i<=16;i++){
                String path="/image/explode/e"+i+".gif";
                logger.info("路径{}",path);
                bufferedImageList[i-1]=ImageIO.read(ExplodeResourceManager.class.getResourceAsStream(path));
            }
        } catch (IOException e) {
            logger.error("加载坦克资源失败",e);
        }
    }
}
