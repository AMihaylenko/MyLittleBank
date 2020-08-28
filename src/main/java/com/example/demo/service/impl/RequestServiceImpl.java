package com.example.demo.service.impl;

import com.example.demo.model.Request;
import com.example.demo.repository.RequestRepository;
import com.example.demo.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl implements RequestService {

    private final RequestRepository requestRepository;

    @Autowired
    public RequestServiceImpl(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public Long sendRequest(Long userId, String message) {
        Request request = new Request();
        request.setDescription(message);
        return null;
    }
}
