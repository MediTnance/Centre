/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meditenance.centre.DAO;

import org.meditenance.centre.DAO.model.DAO;
import java.util.List;
import org.hibernate.Session;
import org.meditenance.centre.domain.Employee;
import org.meditenance.centre.util.HibernateUtil;

/**
 *
 * @author Talus
 */
public class EmployeeDAO extends DAO<Employee> {
  @Override
  public Employee getById(Integer id) {
    Session s = HibernateUtil.getSessionFactory().openSession();
    s.beginTransaction();
    Employee o = (Employee) s.get(Employee.class, id);
    s.getTransaction().commit();
    s.close();

    return o;
  }

  @Override
  public List<Employee> getAll() {
    Session s = HibernateUtil.getSessionFactory().openSession();
    s.beginTransaction();
    List<Employee> l = s.createQuery("from Employee").list();
    s.getTransaction().commit();
    s.close();

    return l;
  }
}
