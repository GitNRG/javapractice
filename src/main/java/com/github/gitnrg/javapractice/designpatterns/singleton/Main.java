package com.github.gitnrg.javapractice.designpatterns.singleton;

public class Main {

    public static void main(String[] args) {
        var instance1 = Singleton.getInstance();
        var instance2 = Singleton.getInstance();

        // prints 'true' because the ref is the same
        System.out.println(instance1 == instance2);
    }
}
