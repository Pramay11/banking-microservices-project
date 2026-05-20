package com.bank.loanservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String loanType;

    private Double amount;

    private Integer duration;

    public Loan() {
    }

    public Loan(Long id, String loanType, Double amount, Integer duration) {
        this.id = id;
        this.loanType = loanType;
        this.amount = amount;
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}