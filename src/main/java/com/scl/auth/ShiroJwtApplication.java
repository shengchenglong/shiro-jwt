package com.scl.auth;

import com.scl.auth.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class ShiroJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroJwtApplication.class, args);
    }

    @Bean
    public Map<String, User> userDao() {
        Map<String, User> userMap = new HashMap<>();
        userMap.put("admin", new User("admin", "admin", "admin", "view,edit"));
        userMap.put("scl", new User("scl", "scl", "user", "view"));
        return userMap;
    }
}
