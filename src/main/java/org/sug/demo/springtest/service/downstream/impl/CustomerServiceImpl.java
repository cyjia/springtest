package org.sug.demo.springtest.service.downstream.impl;

import org.springframework.stereotype.Service;
import org.sug.demo.springtest.model.Customer;
import org.sug.demo.springtest.model.DateOfBirth;
import org.sug.demo.springtest.model.User;
import org.sug.demo.springtest.service.downstream.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public Customer createCustomer(User user, DateOfBirth dateOfBirth) {
        return new Customer();
    }

    @Override
    public Customer createLinkedCustomer(User user, DateOfBirth dateOfBirth, String accountNumber) {
        return new Customer();
    }
}
