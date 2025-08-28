package com.github.gitnrg.javapractice.other.starvation;

public class Stravation {
    public static void main(String[] args) {
        var t1 = new Thread(() -> {
            while (true) {
                System.out.println("High priority thread is running");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.setPriority(Thread.MAX_PRIORITY);

        var t2 = new Thread(() -> {
            while (true) {
                System.out.println("Low priority thread is running");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t2.setPriority(Thread.MIN_PRIORITY);

        t1.run();
        t2.run();
    }
}
