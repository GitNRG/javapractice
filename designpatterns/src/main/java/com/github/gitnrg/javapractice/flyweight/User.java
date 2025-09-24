package com.github.gitnrg.javapractice.flyweight;

public class User {
    private String name;
    private UserOccupation occupation;

    public User(String name, UserOccupation occupation) {
        this.name = name;
        this.occupation = occupation;
    }

    public String getName() {
        return name;
    }

    public UserOccupation getOccupation() {
        return occupation;
    }
}
