package com.app.simple_payroll.auth.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}