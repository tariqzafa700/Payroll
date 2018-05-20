package com.app.simple_payroll.auth.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_id")
  private Long id;
  
  private String name;

  @OneToMany(mappedBy = "primaryKey.user",
      cascade = CascadeType.ALL)
  private Set<EmployeeGroup> empGroups = new HashSet<EmployeeGroup>();
  
  private String designation;
  
  private Integer pay;
  
  public Long getId() {
	return id;
	}
	  
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDesignation() {
		return designation;
	}
	
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public Integer getPay() {
		return pay;
	}
	
	public void setPay(Integer pay) {
		this.pay = pay;
	}
	
  public Set<EmployeeGroup> getUserGroups() {
    return empGroups;
  }
  
  public void setUserGroups(Set<EmployeeGroup> empGroups) {
    this.empGroups = empGroups;
  }
  
  public void addUserGroup(EmployeeGroup userGroup) {
    this.empGroups.add(userGroup);
  }   
}
