package com.example.exercise.week2.nio.httpserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 */
public class MyHttpServer3 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9903);
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 2);
//        ExecutorService executor =new ThreadPoolExecutor(4,8,10,TimeUnit.SECONDS,new ArrayBlockingQueue<>(1000));
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                executor.execute(() -> {
                    service(socket);
//                    System.out.println(Thread.currentThread().getName());
                });
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
            String body = "hello my nio3";
            printWriter.println("Content-Length:" + body.getBytes().length);
            printWriter.println();

            printWriter.write(body);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
