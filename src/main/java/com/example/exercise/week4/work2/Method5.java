package com.example.exercise.week4.work2;


import lombok.SneakyThrows;

import java.util.Random;

public class Method5 {
    private static Integer value;

    /**
     * 使用共享变量，主线程一直循环等待
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Runnable runnable = new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + ": 子线程run..");
                value = new Random().nextInt(100);
            }
        };
        Thread t1 = new Thread(runnable);
        t1.start();

        while (true){
            if (value!=null){
                System.out.println(Thread.currentThread().getName() + ": result=" + value);
                break;
            }
            Thread.sleep(10);
        }
        System.out.println(Thread.currentThread().getName() + ": 主线程end...");
    }
}
