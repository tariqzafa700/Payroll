package com.app.simple_payroll.repositories.impl;


  import java.util.List;

  import javax.persistence.EntityManager;
  import javax.persistence.PersistenceContext;

  import org.springframework.stereotype.Repository;

  import com.app.simple_payroll.auth.model.Group;
  import com.app.simple_payroll.repositories.GroupRepository;

  @Repository
  public class GroupRepositoryJPAImpl  implements GroupRepository {
    @PersistenceContext 
    private EntityManager entityManager;  
    @Override
    public long save(Group grp) {
      entityManager.persist(grp);
      return 0;
    }

    @Override
    public Group get(long id) {
      return entityManager.find(Group.class, id);
    }

    @Override
    public List<Group> list() {
      String hql = "FROM Group as grp ORDER BY grp.id";
      return (List<Group>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void update(long id, Group grp) {
      Group emp = get(id);
      emp.setName(emp.getName());
      entityManager.flush();    
    }

    @Override
    public void delete(long id) {

    }

  }


