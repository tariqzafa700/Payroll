package com.app.simple_payroll.repositories.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.simple_payroll.auth.model.Employee;
import com.app.simple_payroll.repositories.EmployeeRepository;

@Repository
public class EmployeeRepositoryHibImpl  {/*

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public long save(Employee employee) {
		return 0;
		sessionFactory.getCurrentSession().save(employee);
	    return employee.getId();
	}

	@Override
	public Employee get(long id) {
	    return sessionFactory.getCurrentSession().get(Employee.class, id);
	}

	@Override
	public List<Employee> list() {
		Session session = sessionFactory.getCurrentSession();
	      //CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
	      Root<Employee> root = cq.from(Employee.class);
	      cq.select(root);
	      Query<Employee> query = session.createQuery(cq);
	      return query.getResultList();
		return null;
	}

	@Override
	public void update(long id, Employee emp) {
		Session session = sessionFactory.getCurrentSession();
		Employee emp2 = session.byId(Employee.class).load(id);
      emp2.setDesignation(emp.getDesignation());
      session.flush();
	}

	@Override
	public void delete(long id) {
		 Session session = sessionFactory.getCurrentSession();
	      Employee book = session.byId(Employee.class).load(id);
	      session.delete(book);
	}

*/}
