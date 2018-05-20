package com.app.simple_payroll.service;

import com.app.simple_payroll.auth.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}