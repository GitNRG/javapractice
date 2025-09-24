package com.github.gitnrg.javapractice.deadlock;

import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Deadlock {
    private static Lock lock1 = new ReentrantLock();
    private static Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        System.out.println("Starting");

        var t1 = new Thread(() -> {
            System.out.println("Thread 1: started");
            try {
                System.out.println("Thread 1: Acquiring lock 1");
                lock1.lock();
                System.out.println("Thread 1: Acquired lock 1");
                Thread.sleep(1000);
                System.out.println("Thread 1: Acquiring lock 2");
                lock2.lock();
                System.out.println("Thread 1: Acquired lock 2");
            } catch (InterruptedException e) {
                lock1.unlock();
                lock2.unlock();
            }
            System.out.println("Thread 1: finished");
        });

        var t2 = new Thread(() -> {
            System.out.println("Thread 2: started");
            try {
                System.out.println("Thread 2: Acquiring lock 2");
                lock2.lock();
                System.out.println("Thread 2: Acquired lock 2");
                Thread.sleep(1000);
                System.out.println("Thread 2: Acquiring lock 1");
                lock1.lock();
                System.out.println("Thread 2: Acquired lock 1");
            } catch (InterruptedException e) {
                lock2.unlock();
                lock1.unlock();
            }
            System.out.println("Thread 2: finished");
        });

        var pool = Executors.newFixedThreadPool(2);
        pool.execute(t1);
        pool.execute(t2);
        pool.close();
    }
}
