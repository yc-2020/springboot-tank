package com.example.tank.server;

import com.example.tank.common.enums.MsgType;
import com.example.tank.common.msg.AbsMsg;

/**
 * @author yc
 * @date 2022/4/16 15:30
*/
public class MsgA extends AbsMsg {
    private String body;
    @Override
    public MsgType getMsgType() {
        return MsgType.A;
    }


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    @Override
    public String toString() {
        return "MsgA{" +
                "body='" + body + '\'' +
                '}';
    }
}
