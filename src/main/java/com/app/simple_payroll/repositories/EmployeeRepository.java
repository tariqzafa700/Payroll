package com.app.simple_payroll.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.simple_payroll.auth.model.Employee;
import com.app.simple_payroll.auth.model.EmployeeGroups;

//@Repository
public interface EmployeeRepository {
   long save(Employee book);
   Employee get(long id);
   List<Employee> list();
   void update(long id, Employee book);
   void delete(long id);
  void addEmployeeToGroups(Long empId, EmployeeGroups groups);
}