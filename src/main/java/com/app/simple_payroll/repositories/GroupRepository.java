package com.app.simple_payroll.repositories;

import java.util.List;

import com.app.simple_payroll.auth.model.Group;

public interface GroupRepository {
  long save(Group book);
  Group get(long id);
  List<Group> list();
  void update(long id, Group book);
  void delete(long id);
}
