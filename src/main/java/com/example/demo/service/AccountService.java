package com.example.demo.service;

public interface AccountService {

    void moneyTransfer(Long accountId, Long receiveAccount, Long amount);

    Long getAmount(Long accountId);

    Long deposit(Long accountId, Long amount);

    Long withdraw(Long accountId, Long amount);
}
