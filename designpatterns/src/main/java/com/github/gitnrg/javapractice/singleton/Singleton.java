package com.github.gitnrg.javapractice.singleton;

public final class Singleton {
    private static volatile Singleton instance;

    public Singleton() {
    }

    public static Singleton getInstance() {
       var localRef = instance;
       if (localRef == null) {
           synchronized (Singleton.class) {
               localRef = instance;
               if (localRef == null) {
                   instance = localRef = new Singleton();
               }
           }
       }
       return localRef;
    }
}
