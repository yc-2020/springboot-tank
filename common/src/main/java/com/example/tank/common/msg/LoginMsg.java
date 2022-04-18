package com.example.tank.common.msg;

import com.example.tank.common.enums.MsgType;
import com.example.tank.common.mode.Tank;

import java.util.UUID;

/**
 * @author yc
 * @date 2022/4/18 8:57
*/
public class LoginMsg extends AbsMsg {
    /**
     * tank 唯一标识
     */
    private UUID id;

    /**
     * tank 队伍
     */
    private String team;

    public LoginMsg(Tank tank) {
        this.id=tank.getUuid();
        this.team=tank.getTeam();
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public MsgType getMsgType() {
        return MsgType.LOGIN;
    }

    @Override
    public void handle() {

    }
}
