package com.bank.accountservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountHolderName;

    private String accountNumber;

    private Double balance;

    public Account() {
    }

    public Account(Long id, String accountHolderName, String accountNumber, Double balance) {
        this.id = id;
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}