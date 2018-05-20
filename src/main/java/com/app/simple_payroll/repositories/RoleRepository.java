package com.app.simple_payroll.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.simple_payroll.auth.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
