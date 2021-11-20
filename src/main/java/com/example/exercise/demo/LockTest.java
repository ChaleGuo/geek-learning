package com.example.exercise.demo;

public class LockTest {
    static class Test {
        public synchronized void print(String name) {
            System.out.println("print " + name);
        }
    }

    public static void main(String[] args) {
        Test test = new Test();

        Thread t1 = new Thread(() -> {
            try {
                synchronized (test){
                    test.wait();
                    test.print("1");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                synchronized (test){
                    test.notify();
                    test.print("2");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }

}
