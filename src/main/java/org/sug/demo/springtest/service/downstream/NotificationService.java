package org.sug.demo.springtest.service.downstream;

import org.sug.demo.springtest.model.User;

public interface NotificationService {
    void sendValidationEmail(User user);

    void sendWelcomeEmail(User user);
}
