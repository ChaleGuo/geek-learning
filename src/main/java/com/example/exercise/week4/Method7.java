package com.example.exercise.week4;


import lombok.SneakyThrows;

import java.util.Random;

public class Method7 {
    private static Integer value;
    private static Object obj = new Object();

    /**
     * 共享变量+synchronized+同一把锁，wait,notify唤醒
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Runnable runnable = new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                synchronized (obj) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + ": 子线程run..");
                    value = new Random().nextInt(100);
                    obj.notifyAll();
                }
            }
        };
        Thread t1 = new Thread(runnable);
        t1.start();
        synchronized (obj) {
            System.out.println("主线程获取到obj锁");
            obj.wait();
        }


        System.out.println(Thread.currentThread().getName() + ": result=" + value);
        System.out.println(Thread.currentThread().getName() + ": 主线程end...");
    }
}
