/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meditenance.centre.DAO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.meditenance.centre.domain.Client;
import org.meditenance.centre.domain.Employee;
import org.meditenance.centre.domain.Intervention;
import org.meditenance.centre.util.HibernateUtil;

/**
 *
 * @author Talus
 */
public class InterventionDAO extends org.meditenance.centre.DAO.model.InterventionDAO {
  @Override
  public List<Intervention> getByEmployee(Employee e) {
    Session s = HibernateUtil.getSessionFactory().openSession();
    s.beginTransaction();
    List<Intervention> l = s.createQuery("from Intervention where employee.id = " + e.getId()).list();
    s.getTransaction().commit();
    s.close();

    return l;
  }

  @Override
  public List<Intervention> getByClient(Client c) {
    Session s = HibernateUtil.getSessionFactory().openSession();
    s.beginTransaction();
    List<Intervention> l = s.createQuery("from Intervention where client.id = " + c.getId()).list();
    s.getTransaction().commit();
    s.close();

    return l;
  }

  @Override
  public Intervention getById(Integer id) {
    Session s = HibernateUtil.getSessionFactory().openSession();
    s.beginTransaction();
    Intervention i = (Intervention) s.get(Intervention.class, id);
    s.getTransaction().commit();
    s.close();

    return i;
  }

  @Override
  public List<Intervention> getAll() {
    Session s = HibernateUtil.getSessionFactory().openSession();
    s.beginTransaction();
    List<Intervention> l = s.createQuery("from Intervention").list();
    s.getTransaction().commit();
    s.close();

    return l;
  }

  @Override
  public List<Intervention> getByClientAndEmployee(Client c, Employee e) {
    Session s = HibernateUtil.getSessionFactory().openSession();
    s.beginTransaction();
    List<Intervention> l = s.createQuery("from Intervention where client.id = " + c.getId() + " and employee.id = " + e.getId()).list();
    s.getTransaction().commit();
    s.close();

    return l;
  }

    @Override
    public List<Intervention> getByDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String t1 = dateFormat.format(date);
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        List<Intervention> l = s.createQuery("from Intervention where begin like '" + t1 + "%'").list();
        s.getTransaction().commit();
        s.close();

        return l;
    }
}
