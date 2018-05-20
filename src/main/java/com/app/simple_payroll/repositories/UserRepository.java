package com.app.simple_payroll.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.simple_payroll.auth.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
