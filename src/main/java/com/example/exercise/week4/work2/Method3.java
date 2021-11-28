package com.example.exercise.week4.work2;


import lombok.SneakyThrows;

public class Method3 {
    private static Integer value;

    /**
     * 使用共享变量，主线程中调用join，等待子线程执行完毕后获取共享变量的值
     *
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
                value = SumUtil.sum();
            }
        };
        Thread t1 = new Thread(runnable);
        t1.start();
        t1.join();

        System.out.println("异步计算结果为：" + value);
        System.out.println(Thread.currentThread().getName() + ": 主线程end...");
    }
}
