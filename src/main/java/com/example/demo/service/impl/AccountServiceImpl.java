package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    @Transactional
    public void moneyTransfer(Long senderId, Long recipientId, Long amount) {
        Account senderAccount = Optional.of(accountRepository.getOne(senderId))
                .orElseThrow(() -> new ResourceNotFoundException("Не найден счет отправителя"));
        Account recipientAccount = Optional.of(accountRepository.getOne(recipientId))
                .orElseThrow(() -> new ResourceNotFoundException("Не найден счет получателя"));

        senderAccount.setBalance(senderAccount.getBalance() - amount);
        recipientAccount.setBalance(recipientAccount.getBalance() + amount);

        accountRepository.saveAndFlush(senderAccount);
        accountRepository.saveAndFlush(recipientAccount);
    }

    @Override
    public Long getAmount(Long accountId) {
        return Optional.of(accountRepository.getOne(accountId).getBalance())
                .orElseThrow(() -> new ResourceNotFoundException("Не найден счет"));
    }

    @Override
    @Transactional
    public Long deposit(Long accountId, Long amount) {
        Account account = Optional.of(accountRepository.getOne(accountId))
                .orElseThrow(() -> new ResourceNotFoundException("Не найден счет"));

        account.setBalance(account.getBalance() + amount);

        accountRepository.saveAndFlush(account);

        return account.getBalance();
    }

    @Override
    @Transactional
    public Long withdraw(Long accountId, Long amount) {
        Account account = Optional.of(accountRepository.getOne(accountId))
                .orElseThrow(() -> new ResourceNotFoundException("Не найден счет"));

        account.setBalance(account.getBalance() - amount);

        accountRepository.saveAndFlush(account);

        return account.getBalance();
    }
}
