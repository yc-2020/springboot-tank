package com.example.tank.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author yc
 * @date 2022/4/16 11:05
*/
public class Main {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("localhost",8888);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello 123  service".getBytes());
        outputStream.flush();
        InputStream inputStream = socket.getInputStream();
        byte[] b=new byte[1025];
        inputStream.read(b);
    }
}
