package org.sug.demo.springtest.service;

import org.sug.demo.springtest.model.DateOfBirth;

public interface RegistrationService {
    void registerAnonymousUser(String ouid, String firstName, String lastName, DateOfBirth dateOfBirth);

    void registerLinkedUser(String ouid, String firstName, String lastName, DateOfBirth dateOfBirth, String accountNumber);

    void completeRegistration(String token);
}
