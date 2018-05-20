package com.app.simple_payroll.auth.model;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;

@Entity
@Table(name="employee_group")
@AssociationOverrides({
  @AssociationOverride(name="primaryKey.user", joinColumns=@JoinColumn(name="user_id")),
  @AssociationOverride(name = "primaryKey.group", joinColumns = @JoinColumn(name = "group_id"))
})
public class EmployeeGroup {

  private EmployeeGroupId primaryKey = new EmployeeGroupId();
  
  @EmbeddedId
  public EmployeeGroupId getPrimaryKey() {
      return primaryKey;
  }

  public void setPrimaryKey(EmployeeGroupId primaryKey) {
      this.primaryKey = primaryKey;
  }

  @Transient
  public Employee getEmployee() {
      return getPrimaryKey().getEmployee();
  }

  public void setEmployee(Employee user) {
      getPrimaryKey().setEmployee(user);
  }

  @Transient
  public Group getGroup() {
      return getPrimaryKey().getGroup();
  }

  public void setGroup(Group group) {
      getPrimaryKey().setGroup(group);
  }
}
