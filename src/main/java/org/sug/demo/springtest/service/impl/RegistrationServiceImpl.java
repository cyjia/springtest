package org.sug.demo.springtest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sug.demo.springtest.model.Customer;
import org.sug.demo.springtest.model.DateOfBirth;
import org.sug.demo.springtest.model.User;
import org.sug.demo.springtest.service.downstream.impl.CustomerServiceImpl;
import org.sug.demo.springtest.service.downstream.impl.NotificationServiceImpl;
import org.sug.demo.springtest.service.RegistrationService;
import org.sug.demo.springtest.service.downstream.impl.UserServiceImpl;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    CustomerServiceImpl customerService;
    UserServiceImpl userService;
    NotificationServiceImpl notificationService;

    public RegistrationServiceImpl() {
    }

    @Autowired
    public RegistrationServiceImpl(UserServiceImpl userService, CustomerServiceImpl customerService, NotificationServiceImpl notificationService) {

        this.userService = userService;
        this.customerService = customerService;
        this.notificationService = notificationService;
    }

    @Override
    public void registerAnonymousUser(String ouid, String firstName, String lastName, DateOfBirth dateOfBirth) {
        User user = userService.createUser(ouid, firstName, lastName);

        Customer customer = customerService.createCustomer(user, dateOfBirth);

        notificationService.sendValidationEmail(user);
    }

    @Override
    public void registerLinkedUser(String ouid, String firstName, String lastName, DateOfBirth dateOfBirth, String accountNumber) {
        User user = userService.createUser(ouid, firstName, lastName);
        Customer customer = customerService.createLinkedCustomer(user, dateOfBirth, accountNumber);
        notificationService.sendValidationEmail(user);
    }

    @Override
    public void completeRegistration(String token) {
        User user = userService.retrieveUser(token);
        notificationService.sendWelcomeEmail(user);
    }


//    @Autowired
//    public RegisterUserServiceImpl(CustomerService customerService, UserService userService, NotificationService notificationService) {
//        this.customerService = customerService;
//        this.userService = userService;
//        this.notificationService = notificationService;
//    }
}
