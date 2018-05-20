package com.app.simple_payroll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.simple_payroll.auth.model.Group;
import com.app.simple_payroll.repositories.EmployeeRepository;
import com.app.simple_payroll.repositories.GroupRepository;
import com.app.simple_payroll.service.GroupService;

public class GroupServiceImpl implements GroupService {

  @Autowired
  private GroupRepository grpDao;
  
  @Override
  public long save(Group grp) {
    return grpDao.save(grp);
  }

  @Override
  public Group get(long id) {
    return grpDao.get(id);

  }

  @Override
  public List<Group> list() {
    return grpDao.list();
  }

  @Override
  public void update(long id, Group grp) {
    grpDao.update(id, grp);
  }

  @Override
  public void delete(long id) {
    grpDao.delete(id);
  }
}
