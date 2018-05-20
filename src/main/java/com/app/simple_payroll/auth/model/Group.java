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
@Table(name = "group")
public class Group {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "group_id")
  Long id;
  
  String name;
  
  @OneToMany(mappedBy = "primaryKey.group",
      cascade = CascadeType.ALL)
  private Set<EmployeeGroup> empGroups = new HashSet<EmployeeGroup>();

  public String getName() {
  	return name;
  }
  
  public void setName(String name) {
  	this.name = name;
  }
  
  public Long getId() {
  	return id;
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
