package com.example.exercise.week4.work2;


import lombok.SneakyThrows;

import java.util.Random;

public class Method3 {
    private static Integer value;

    /**
     * 使用共享变量，主线程中调用join，等待子线程执行完毕后获取共享变量的值
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
        t1.join();

        System.out.println(Thread.currentThread().getName() + ": result=" + value);
        System.out.println(Thread.currentThread().getName() + ": 主线程end...");
    }
}
