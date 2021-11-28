package com.example.exercise.week4.work2;


import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Method1 {
    /**
     * FutureTask，提交任务Callable，通过FutureTask获取返回值
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        Callable<Object> callable = () -> {
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + ": 子线程run..");
            return SumUtil.sum();
        };
        FutureTask<Object> task = new FutureTask<>(callable);
        Thread t1 = new Thread(task);
        t1.start();
        System.out.println("异步计算结果为：" + task.get());

        System.out.println(Thread.currentThread().getName() + ": 主线程end...");
    }
}
