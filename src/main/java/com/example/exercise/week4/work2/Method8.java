package com.example.exercise.week4.work2;


import lombok.SneakyThrows;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Method8 {
    private static Integer value;

    /**
     * 共享变量+ReentrantLock，await+signalAll唤醒
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Runnable runnable = new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                lock.lock();
                try {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + ": 子线程run..");
                    value = new Random().nextInt(100);
                } finally {
                    condition.signalAll();
                    lock.unlock();
                    System.out.println("子线程解锁");
                }
            }
        };
        Thread t1 = new Thread(runnable);
        t1.start();
        lock.lock();
        try {
            condition.await();
        } finally {
            lock.unlock();
            System.out.println("主线程解锁");
        }

        System.out.println(Thread.currentThread().getName() + ": result=" + value);
        System.out.println(Thread.currentThread().getName() + ": 主线程end...");
    }
}
