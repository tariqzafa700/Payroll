package com.app.simple_payroll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.simple_payroll.auth.model.Employee;
import com.app.simple_payroll.repositories.EmployeeRepository;
import com.app.simple_payroll.service.EmployeeService;


@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empDao;
	
	   @Transactional
	@Override
	public long save(Employee emp) {
        return empDao.save(emp);
	}

	@Override
	public Employee get(long id) {
        return empDao.get(id);
	}

	@Override
	public List<Employee> list() {
        return empDao.list();
	}

	@Override
	public void update(long id, Employee emp) {
        empDao.update(id, emp);
	}

	@Override
	public void delete(long id) {
        empDao.delete(id);
	}

}
