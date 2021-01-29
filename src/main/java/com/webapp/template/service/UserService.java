package com.webapp.template.service;

import com.webapp.template.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private final List<User> users;

    public UserService(){
        users = new ArrayList<>(Arrays.asList(
                new User("Gull", "123456"),
                new User("Fateh", "123456"),
                new User("gk5555", "123456"),
                new User("jamal", "123456")
        ));
    }

    public void createUser(User user){
        List<User> tempList = users
                .stream()
                .filter(u -> u.getUsername().equals(user.getUsername()))
                .collect(Collectors.toList());
            if (tempList.size() > 0) {
                throw new IllegalArgumentException("username already exists");
            }else{
                users.add(user);
            }
    }

    public User signIn(String username, String password){
        List<User> tempList = users
                .stream()
                .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
                .collect(Collectors.toList());

        if (tempList.size() > 0) {
            return tempList.get(0);
        }else{
            throw new IllegalArgumentException("username or password is incorrect.");
        }
    }
}
