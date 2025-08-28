package com.github.gitnrg.javapractice.other.livelock;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Livelock {
    private static Lock lock1 = new ReentrantLock();
    private static Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        System.out.println("Starting");

        var t1 = new Thread(() -> {
            System.out.println("Thread 1: started");
            var needRetry = true;
            while (needRetry) {
                try {
                    System.out.println("Thread 1: Acquiring lock 1");
                    lock1.lock();
                    System.out.println("Thread 1: Acquired lock 1");
                    Thread.sleep(1000);
                    System.out.println("Thread 1: Acquiring lock 2");
                    if (lock2.tryLock(100, TimeUnit.MILLISECONDS)) {
                        System.out.println("Thread 1: Acquired lock 2");
                        needRetry = false;
                        lock2.unlock();
                        System.out.println("Thread 1: Released lock 2");
                        lock1.unlock();
                        System.out.println("Thread 1: Released lock 1");
                    } else {
                        System.out.println("Thread 1: Acquiring lock 2 failed, unlocking lock 1");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                        lock1.unlock();
                        System.out.println("Thread 1: Released lock 1");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Thread 1: finished");
        });

        var t2 = new Thread(() -> {
            System.out.println("Thread 2: started");
            var needRetry = true;
            while (needRetry) {
                try {
                    System.out.println("Thread 2: Acquiring lock 2");
                    lock2.lock();
                    System.out.println("Thread 2: Acquired lock 2");
                    Thread.sleep(1000);
                    System.out.println("Thread 2: Acquiring lock 1");
                    if (lock1.tryLock(100, TimeUnit.MILLISECONDS)) {
                        System.out.println("Thread 2: Acquired lock 1");
                        needRetry = false;
                        lock1.unlock();
                        System.out.println("Thread 1: Released lock 1");
                        lock2.unlock();
                        System.out.println("Thread 1: Released lock 2");
                    } else {
                        System.out.println("Thread 2: Acquiring lock 1 failed, unlocking lock 2");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                        lock2.unlock();
                        System.out.println("Thread 2: Released lock 2");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Thread 2: finished");
        });

        var pool = Executors.newFixedThreadPool(2);
        pool.execute(t1);
        pool.execute(t2);
        pool.close();
    }
}
