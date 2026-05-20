package com.bank.customerservice.controller;

import com.bank.customerservice.entity.Customer;
import com.bank.customerservice.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return service.createCustomer(customer);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }
}