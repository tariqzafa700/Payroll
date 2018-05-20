package com.app.simple_payroll.service;

import java.util.List;

import com.app.simple_payroll.auth.model.Group;

public interface GroupService {

  long save(Group book);
  Group get(long id);
  List<Group> list();
  void update(long id, Group book);
  void delete(long id);

}
