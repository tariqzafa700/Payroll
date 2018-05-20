package com.app.simple_payroll.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.simple_payroll.auth.model.EmployeeGroups;
import com.app.simple_payroll.repositories.EmployeeRepository;
import com.app.simple_payroll.service.EmployeeGroupService;

@Service
public class EmployeeGroupServiceImpl implements EmployeeGroupService {
  
  @Autowired
  private EmployeeRepository empDao;
  
  @Override
  public void addEmployeeToGroups(Long empId, EmployeeGroups groups) {
    empDao.addEmployeeToGroups(empId, groups);
  }
}
