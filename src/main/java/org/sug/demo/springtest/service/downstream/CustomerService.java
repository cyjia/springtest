package org.sug.demo.springtest.service.downstream;

import org.sug.demo.springtest.model.Customer;
import org.sug.demo.springtest.model.DateOfBirth;
import org.sug.demo.springtest.model.User;

public interface CustomerService {
    Customer createCustomer(User user, DateOfBirth dateOfBirth);

    Customer createLinkedCustomer(User user, DateOfBirth dateOfBirth, String accountNumber);
}
