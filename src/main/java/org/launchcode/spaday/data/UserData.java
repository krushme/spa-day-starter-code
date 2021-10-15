package org.launchcode.spaday.data;

import org.launchcode.spaday.models.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserData {

    private static final Map<Integer, User> users = new HashMap<>();

    //add method
    public static void add(User user) {
        users.put(user.getId(), user);
    }
    //get all method

    public static Collection<User> getAll() {
        return users.values();
    }

    //get by ID
    public static User getByID(int id) {
        return users.get(id);
    }

}
