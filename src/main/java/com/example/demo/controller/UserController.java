package com.example.demo.controller;

import com.example.demo.controller.request.RegistrationRequest;
import com.example.demo.controller.response.BaseResponse;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController extends BaseController {

    private final UserService userService;


    public void login() {

    }

    @GetMapping(value = "/get_all")
    @PreAuthorize("hasAuthority('write')")
    public BaseResponse<List<User>> getAll() {
        return new BaseResponse<>(userService.getAll());
    }

    public void registration(RegistrationRequest registrationRequest) {

    }
}
