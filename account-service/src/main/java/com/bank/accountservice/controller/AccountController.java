package com.bank.accountservice.controller;

import com.bank.accountservice.entity.Account;
import com.bank.accountservice.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return service.createAccount(account);
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return service.getAllAccounts();
    }
}