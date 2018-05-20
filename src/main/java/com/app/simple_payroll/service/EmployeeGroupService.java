package com.app.simple_payroll.service;

import java.util.List;

import com.app.simple_payroll.auth.model.EmployeeGroups;

public interface EmployeeGroupService {

  void addEmployeeToGroups(Long empId, EmployeeGroups groups);
}
