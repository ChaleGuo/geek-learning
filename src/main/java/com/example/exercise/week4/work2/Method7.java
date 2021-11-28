package com.example.exercise.week4.work2;


import lombok.SneakyThrows;

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
                    value = SumUtil.sum();
                    obj.notifyAll();
                }
            }
        };
        Thread t1 = new Thread(runnable);
        synchronized (obj) {
            t1.start();
            System.out.println("主线程获取到obj锁");
            obj.wait();
        }


        System.out.println("异步计算结果为：" + value);
        System.out.println(Thread.currentThread().getName() + ": 主线程end...");
    }
}
