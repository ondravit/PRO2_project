package com.example.pro2_project.service;

import com.example.pro2_project.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {

    private ArrayList<User> users = new ArrayList<>();

    @Override
    public ArrayList<User> getAllUsers() {
        return users;
    }

    @Override
    public void saveUser(User user) {
        users.add(user);
    }
}
