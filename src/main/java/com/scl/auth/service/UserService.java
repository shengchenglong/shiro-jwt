package com.scl.auth.service;

import com.scl.auth.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserService {

    public User getUser(String username) {

        Map<String, User> userMap = new HashMap<>();
        userMap.put("admin", new User("admin", "admin", "admin", "view,edit"));
        userMap.put("scl", new User("scl", "scl", "user", "view"));

        if (!userMap.keySet().contains(username)) {
            return null;
        }
        return userMap.get(username);
    }

}
