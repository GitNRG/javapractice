package com.github.gitnrg.javapractice.designpatterns.flyweight;

import java.util.Set;

public class UserOccupation {
    private String role;
    private Set<String> acl;

    public UserOccupation(String role, Set<String> acl) {
        this.role = role;
        this.acl = acl;
    }

    public String getRole() {
        return role;
    }

    public Set<String> getAcl() {
        return acl;
    }
}
