package org.sug.demo.springtest.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.sug.demo.springtest.model.DateOfBirth;
import org.sug.demo.springtest.model.User;
import org.sug.demo.springtest.service.downstream.impl.CustomerServiceImpl;
import org.sug.demo.springtest.service.downstream.impl.NotificationServiceImpl;
import org.sug.demo.springtest.service.downstream.impl.UserServiceImpl;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class Test1PackageVisible {
    private RegistrationServiceImpl registrationService;
    private NotificationServiceImpl notificationService;
    private UserServiceImpl userService;
    private CustomerServiceImpl customerService;

    @Before
    public void setUp() throws Exception {
        notificationService = mock(NotificationServiceImpl.class);
        userService = mock(UserServiceImpl.class);
        customerService = mock(CustomerServiceImpl.class);
        registrationService = new RegistrationServiceImpl();
        registrationService.userService = userService;
        registrationService.customerService = customerService;
        registrationService.notificationService = notificationService;
    }

    @Test
    public void should_send_validation_email() throws Exception {
        registrationService.registerAnonymousUser("fn.ln2014@gmail.com", "Fn", "Ln", new DateOfBirth());

        verify(notificationService).sendValidationEmail(any(User.class));
    }

}
