package com.github.gitnrg.javapractice.flyweight;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserOccupationFactory {
    private static final Map<String, UserOccupation> USER_ROLES = new HashMap<String, UserOccupation>();

    // warning: not thread safe + potential memory leak
    public static UserOccupation getUser(String role, Set<String> acl) {
        if (USER_ROLES.containsKey(role)) {
            return USER_ROLES.get(role);
        }
        var occupation = new UserOccupation(role, acl);
        USER_ROLES.put(role, occupation);
        return occupation;
    }
}
