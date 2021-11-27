package com.example.exercise.week4;


import lombok.SneakyThrows;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Method4 {
    private static Integer value;

    /**
     * 使用共享变量，CountDownLatch计数
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        Runnable runnable = new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + ": 子线程run..");
                    value = new Random().nextInt(100);
                } finally {
                    latch.countDown();
                }
            }
        };
        Thread t1 = new Thread(runnable);
        t1.start();
        latch.await();

        System.out.println(Thread.currentThread().getName() + ": result=" + value);
        System.out.println(Thread.currentThread().getName() + ": 主线程end...");
    }
}
