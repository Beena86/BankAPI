package com.bankapp.bankaccountapi.service.Interface;

import com.bankapp.bankaccountapi.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    void deleteUser(Long id);
}
