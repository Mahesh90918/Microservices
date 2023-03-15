package com.microServices.service;

import org.springframework.stereotype.Service;

import com.microServices.Exception.UserNotFoundException;
import com.microServices.model.User;

@Service
public interface UserService {
    public void saveUser(User user);
    public User getUserByNameAndPassword(String name, String password) throws UserNotFoundException;
}