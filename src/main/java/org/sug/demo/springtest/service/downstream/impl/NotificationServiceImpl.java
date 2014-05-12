package org.sug.demo.springtest.service.downstream.impl;

import org.springframework.stereotype.Service;
import org.sug.demo.springtest.model.User;
import org.sug.demo.springtest.service.downstream.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Override
    public void sendValidationEmail(User user) {

    }

    @Override
    public void sendWelcomeEmail(User user) {

    }
}
