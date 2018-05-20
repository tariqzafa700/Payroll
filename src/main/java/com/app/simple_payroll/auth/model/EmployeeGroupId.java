package com.app.simple_payroll.auth.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class EmployeeGroupId implements Serializable { 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Employee emp;
  @ManyToOne(cascade = CascadeType.ALL)
    private Group group;
 
    public Employee getEmployee() {
        return emp;
    }
 
    public void setEmployee(Employee emp) {
        this.emp = emp;
    }
 
    @ManyToOne(cascade = CascadeType.ALL)
    public Group getGroup() {
        return group;
    }
 
    public void setGroup(Group group) {
        this.group = group;
    }
}
