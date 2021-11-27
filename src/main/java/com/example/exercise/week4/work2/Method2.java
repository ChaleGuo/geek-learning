package com.example.exercise.week4.work2;


import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Random;
import java.util.concurrent.*;

public class Method2 {
    /**
     * 使用线程池，守护线程，无需手动关闭，提交任务Callable，通过Future获取返回值
     * 非守护线程，需手动关闭，提交任务Callable，通过Future获取返回值
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //创建守护线程的线程池，无需手动关闭
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService pool = new ThreadPoolExecutor(cores, cores * 2,
                5, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(10),
                new ThreadFactoryBuilder().setNameFormat("guava-thread-%d").setDaemon(true).build());

        Callable<Object> callable = () -> {
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + ": 子线程run..");
            return new Random().nextInt(100);
        };
        Future future = pool.submit(callable);
        System.out.println(Thread.currentThread().getName() + ": result=" + future.get());
        //守护线程需手动关闭
//        pool.shutdown();
        System.out.println(Thread.currentThread().getName() + ": 主线程end...");
    }
}
