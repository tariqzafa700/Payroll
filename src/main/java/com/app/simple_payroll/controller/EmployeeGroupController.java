package com.app.simple_payroll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.simple_payroll.auth.model.Employee;
import com.app.simple_payroll.auth.model.EmployeeGroups;
import com.app.simple_payroll.service.EmployeeGroupService;

public class EmployeeGroupController {

  @Autowired
  EmployeeGroupService empGrpService;
  
  @PutMapping("/employeeGroup/{empId}")
  public ResponseEntity<?> addEmployeeToGroups(@PathVariable("id") Long empId, @RequestBody EmployeeGroups grpIds) {
    empGrpService.addEmployeeToGroups(empId, grpIds);
    return ResponseEntity.ok().body("New employee has been saved with ID:"  +empId+ " with group ids "+grpIds.getGroupIds().toString());
  }
}
