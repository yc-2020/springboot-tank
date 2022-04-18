package com.example.tank.common.msg;

import com.example.tank.common.enums.MsgType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * @author yc
 * @date 2022/4/16 10:55
 */
public abstract class AbsMsg implements Serializable {

    protected static final Logger logger= LoggerFactory.getLogger(AbsMsg.class);
    /**
     * 消息类型
     *
     * @return
     */
    public abstract MsgType getMsgType();

    /**
     * 转bytes
     * @return
     */
    public byte[] toBytes() {
        byte[] byteS = null;
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
            objectOutputStream.writeObject(this);
            objectOutputStream.flush();
            byteS = byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            logger.error("to bytes error",e);
        }
        return byteS;
    }


    /**
     * bytes 转对象
     * @param bytes
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T extends AbsMsg> T parseObject(byte[] bytes, Class<T> clazz) {
        T obj = null;

        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
             ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);) {
            obj = (T) objectInputStream.readObject();
        } catch (Exception e) {
            logger.error("byteArrayToObject failed, " + e);
        }
        return obj;
    }


    /**
     * 处理对象
     */
    public abstract void handle();



}
