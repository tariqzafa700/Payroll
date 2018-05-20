package com.app.simple_payroll.repositories.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.simple_payroll.auth.model.Employee;
import com.app.simple_payroll.auth.model.EmployeeGroups;
import com.app.simple_payroll.repositories.EmployeeRepository;

@Repository
@Transactional
public class EmployeeRepositoryJPAImpl implements EmployeeRepository {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public long save(Employee emp) {
		System.out.println("emp is" + emp.getId()+emp.getName()+ emp.getDesignation());
		 entityManager.persist(emp);
		 return 0;
	}

	@Override
	public Employee get(long id) {
		return entityManager.find(Employee.class, id);
	}

	@Override
	public List<Employee> list() {
		String hql = "FROM Employee as emp ORDER BY emp.id";
		return (List<Employee>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public void update(long id, Employee book) {
		Employee emp = get(id);
		emp.setName(emp.getName());
		emp.setDesignation(emp.getDesignation());
		entityManager.flush();		
	}

	@Override
	public void delete(long id) {
		
	}

  @Override
  public void addEmployeeToGroups(Long empId, EmployeeGroups groups) {
    
  }

}
