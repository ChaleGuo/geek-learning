package com.example.exercise.week4.work2;


import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;

public class Method10 {
    private static Integer value;

    /**
     * 使用共享变量，Semaphore同步
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Semaphore semaphore = new Semaphore(0);
        System.out.println(semaphore.toString());
        Runnable runnable = new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + ": 子线程run..");
                value = SumUtil.sum();
                semaphore.release(2);
            }
        };
        Thread t1 = new Thread(runnable);
        t1.start();
        semaphore.acquire();
        System.out.println(semaphore.toString());

        System.out.println("异步计算结果为：" + value);
        System.out.println(Thread.currentThread().getName() + ": 主线程end...");
    }
}
