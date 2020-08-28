package com.example.demo.controller;

import com.example.demo.controller.response.BaseResponse;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
public class BaseController {

    @ExceptionHandler(ResourceNotFoundException.class)
    public BaseResponse handleResourceNotFound(ResourceNotFoundException e) {
        return BaseResponse.buildErrorResponse(404, e);
    }

}
