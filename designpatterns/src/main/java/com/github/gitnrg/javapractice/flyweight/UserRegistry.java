package com.github.gitnrg.javapractice.flyweight;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserRegistry {
    private List<User> users = new ArrayList<>();

    public User addUser(String name, String role, Set<String> acl) {
        var occupation = UserOccupationFactory.getUser(role, acl);
        var user = new User(name, occupation);
        users.add(user);
        return user;
    }
}
