package com.bank.accountservice.service;

import com.bank.accountservice.entity.Account;
import com.bank.accountservice.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public Account createAccount(Account account) {
        return repository.save(account);
    }

    public List<Account> getAllAccounts() {
        return repository.findAll();
    }
}