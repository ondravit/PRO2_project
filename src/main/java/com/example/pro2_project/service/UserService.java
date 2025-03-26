package com.example.pro2_project.service;

import com.example.pro2_project.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface UserService {
    ArrayList<User> getAllUsers();
    void saveUser(User user);
}
