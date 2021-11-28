package com.example.exercise.week4.work2;


import java.util.concurrent.CompletableFuture;

public class Method9 {
    /**
     * 使用CompletableFuture同步获取
     * demo:https://zhuanlan.zhihu.com/p/344431341
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"  supplyAsync");
            return SumUtil.sum();
        }).thenApply((i -> {
            System.out.println(Thread.currentThread().getName()+"  第一步的结果："+i);
            return i*2;
        }));

        System.out.println("异步计算结果为：" + future.get());
        System.out.println(Thread.currentThread().getName() + ": 主线程end...");
    }
}
