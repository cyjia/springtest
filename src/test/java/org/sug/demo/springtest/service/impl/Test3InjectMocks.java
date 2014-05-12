package org.sug.demo.springtest.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.sug.demo.springtest.model.DateOfBirth;
import org.sug.demo.springtest.model.User;
import org.sug.demo.springtest.service.downstream.impl.CustomerServiceImpl;
import org.sug.demo.springtest.service.downstream.impl.NotificationServiceImpl;
import org.sug.demo.springtest.service.downstream.impl.UserServiceImpl;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class Test3InjectMocks {
    @Mock
    private NotificationServiceImpl notificationService;
    @Mock
    private CustomerServiceImpl customerService;
    @Mock
    private UserServiceImpl userService;
    @InjectMocks
    private RegistrationServiceImpl registrationService;

    @Before
    public void setUp() throws Exception {
        registrationService = new RegistrationServiceImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_register_anonymous_user() throws Exception {
        registrationService.registerAnonymousUser("fn.ln2014@gmail.com", "Fn", "Ln", new DateOfBirth());

        verify(notificationService).sendValidationEmail(any(User.class));
    }

}
