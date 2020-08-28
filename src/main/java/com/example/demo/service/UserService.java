package com.example.demo.service;

import com.example.demo.controller.request.RegistrationRequest;
import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAll();

    void registration(RegistrationRequest registrationRequest);
}
