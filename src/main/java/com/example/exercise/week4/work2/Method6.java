package com.example.exercise.week4.work2;


import lombok.SneakyThrows;

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
                value = SumUtil.sum();
                //子线程到达等待点
                barrier.await();
            }
        };
        Thread t1 = new Thread(runnable);
        t1.start();
        //主线程到达等待点
        barrier.await();

        System.out.println("异步计算结果为：" + value);
        System.out.println(Thread.currentThread().getName() + ": 主线程end...");
    }
}
