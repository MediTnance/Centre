/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meditnance.client.DAO;

import java.util.List;
import org.hibernate.Session;
import org.meditnance.client.domain.Client;
import org.meditnance.client.domain.Employee;
import org.meditnance.client.domain.Intervention;
import org.meditnance.client.util.HibernateUtil;

/**
 *
 * @author Talus
 */
public class InterventionDAO extends org.meditnance.client.DAO.model.InterventionDAO {

  @Override
  public List<Intervention> getByEmployee(Employee e) {
    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
    s.beginTransaction();
    List<Intervention> l = s.createQuery("from Intervention where employee.id = " + e.getId()).list();
    s.getTransaction().commit();
    s.close();

    return l;
  }

  @Override
  public List<Intervention> getByClient(Client c) {
    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
    s.beginTransaction();
    List<Intervention> l = s.createQuery("from Furniture where client.id = " + c.getId()).list();
    s.getTransaction().commit();
    s.close();

    return l;
  }

  @Override
  public Intervention getById(Integer id) {
    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
    s.beginTransaction();
    Intervention i = (Intervention) s.get(Intervention.class, id);
    s.getTransaction().commit();
    s.close();

    return i;
  }

  @Override
  public List<Intervention> getAll() {
    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
    s.beginTransaction();
    List<Intervention> l = s.createQuery("from Intervention").list();
    s.getTransaction().commit();
    s.close();

    return l;
  }
}
