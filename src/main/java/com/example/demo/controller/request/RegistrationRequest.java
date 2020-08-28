package com.example.demo.controller.request;

import lombok.Data;

@Data
public class RegistrationRequest {

    private String name;

    private String login;

    private String password;
}
