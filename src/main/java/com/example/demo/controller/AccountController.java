package com.example.demo.controller;

import com.example.demo.controller.response.BaseResponse;
import com.example.demo.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AccountController extends BaseController{

    private final AccountService accountService;

    @PutMapping(value = "/money_transfer")
    public void moneyTransfer(Long senderId, Long recipientId, Long amount) {
        accountService.moneyTransfer(senderId, recipientId, amount);
    }

    @GetMapping
    public BaseResponse getAmount(Long accountId) {
        return new BaseResponse<>(accountService.getAmount(accountId));
    }

    @PutMapping(value = "/deposit")
    public BaseResponse deposit(Long accountId, Long amount) {
        return new BaseResponse<>(accountService.deposit(accountId, amount));
    }

    @PutMapping(value = "/withdraw")
    public BaseResponse withdraw(Long accountId, Long amount) {
        return new BaseResponse<>(accountService.withdraw(accountId, amount));
    }
}
