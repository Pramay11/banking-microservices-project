package com.bank.transactionservice.service;

import com.bank.transactionservice.entity.Transaction;
import com.bank.transactionservice.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public Transaction createTransaction(Transaction transaction) {
        return repository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }
}