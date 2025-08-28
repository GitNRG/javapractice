package com.github.gitnrg.javapractice.designpatterns.flyweight;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        var registry = new UserRegistry();

        var john = registry.addUser("John", "admin", Set.of("x1"));
        var mike = registry.addUser("Mike", "customer", Set.of("y1"));
        var pete = registry.addUser("Pete", "customer", Set.of("y2"));

        // occupation is reused to the ref is the same for mike and pete
        System.out.println(john.getOccupation() == mike.getOccupation()); // false
        System.out.println(john.getOccupation() == pete.getOccupation()); // false
        System.out.println(mike.getOccupation() == pete.getOccupation()); // true
    }
}
