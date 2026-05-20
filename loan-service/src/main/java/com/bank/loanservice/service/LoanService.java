package com.bank.loanservice.service;

import com.bank.loanservice.entity.Loan;
import com.bank.loanservice.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    private final LoanRepository repository;

    public LoanService(LoanRepository repository) {
        this.repository = repository;
    }

    public Loan createLoan(Loan loan) {
        return repository.save(loan);
    }

    public List<Loan> getAllLoans() {
        return repository.findAll();
    }
}