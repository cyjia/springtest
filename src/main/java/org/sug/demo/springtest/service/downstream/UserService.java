package org.sug.demo.springtest.service.downstream;

import org.sug.demo.springtest.model.User;

public interface UserService {
    User createUser(String ouid, String firstName, String lastName);

    User retrieveUser(String token);
}
