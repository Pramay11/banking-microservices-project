package com.bank.transactionservice.controller;

import com.bank.transactionservice.entity.Transaction;
import com.bank.transactionservice.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return service.createTransaction(transaction);
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return service.getAllTransactions();
    }
}