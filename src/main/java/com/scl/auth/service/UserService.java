package com.scl.auth.service;

import com.scl.auth.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    @Autowired
    private Map<String, User> userDao;

    public User getUser(String username) {
        if (!userDao.keySet().contains(username)) {
            return null;
        }
        return userDao.get(username);
    }

}
