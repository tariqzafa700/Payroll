package com.app.simple_payroll.service;

import java.util.List;

import com.app.simple_payroll.auth.model.Employee;

public interface EmployeeService {
	   long save(Employee book);
	   Employee get(long id);
	   List<Employee> list();
	   void update(long id, Employee book);
	   void delete(long id);
}
