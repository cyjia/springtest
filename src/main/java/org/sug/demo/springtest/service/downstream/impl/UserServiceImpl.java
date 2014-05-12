package org.sug.demo.springtest.service.downstream.impl;

import org.springframework.stereotype.Service;
import org.sug.demo.springtest.model.User;
import org.sug.demo.springtest.service.downstream.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User createUser(String ouid, String firstName, String lastName) {
        return new User();
    }

    @Override
    public User retrieveUser(String token) {
        return new User();
    }
}
