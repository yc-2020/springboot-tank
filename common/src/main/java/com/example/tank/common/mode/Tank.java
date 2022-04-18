package com.example.tank.common.mode;


import com.example.tank.common.enums.Dir;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;

/**
 * @author yc
 * @date 31/3/2022 下午1:37
 */

public class Tank {

    private static final Logger logger = LogManager.getLogger(Tank.class);

    /**
     * 坦克横坐标
     */

    private int x;
    /**
     * 坦克纵坐标
     */

    private int y;

    /**
     * 坦克方向
     */

    private Dir dir;
    /**
     * 移动标记
     */
    private boolean moving = true;

    /**
     * 存活标记
     */

    private boolean liveFlag = true;

    /**
     * 队伍
     */

    private String team;

    private UUID uuid;



    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean getMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }


    public boolean isMoving() {
        return moving;
    }

    public boolean isLiveFlag() {
        return liveFlag;
    }

    public void setLiveFlag(boolean liveFlag) {
        this.liveFlag = liveFlag;
    }


    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
