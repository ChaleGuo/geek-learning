package com.example.exercise.week2.nio.httpserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 单线程的socket
 */
public class MyHttpServer1 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9901);
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                service(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void service(Socket socket) throws IOException {
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
        printWriter.println("HTTP/1.1 200 OK");
        printWriter.println("Content-Type:text/html;charset=utf-8");
        String body = "hello my nio1";
        //注释后前端还是可以正常显示？
        printWriter.println("Content-Length:" + body.getBytes().length);
        printWriter.println();

        printWriter.write(body);
        printWriter.close();
    }
}
