package com.example.exercise.week2.nio01.httpserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 每个请求一个线程
 */
public class MyHttpServer2 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9902);
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                new Thread(() -> {
                    service(socket);
//                    System.out.println(Thread.currentThread().getName());
                }).start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void service(Socket socket) {
        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type:text/html;charset=utf-8");
            String body = "hello my nio2";
            printWriter.println("Content-Length:" + body.getBytes().length);
            printWriter.println();

            printWriter.write(body);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
