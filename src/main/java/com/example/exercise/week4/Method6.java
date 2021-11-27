package com.example.exercise.week4;


import lombok.SneakyThrows;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class Method6 {
    private static Integer value;

    /**
     * 使用共享变量，CyclicBarrier计数
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        CyclicBarrier barrier = new CyclicBarrier(2);
        Runnable runnable = new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + ": 子线程run..");
                value = new Random().nextInt(100);
                //子线程到达等待点
                barrier.await();
            }
        };
        Thread t1 = new Thread(runnable);
        t1.start();
        //主线程到达等待点
        barrier.await();

        System.out.println(Thread.currentThread().getName() + ": result=" + value);
        System.out.println(Thread.currentThread().getName() + ": 主线程end...");
    }
}
