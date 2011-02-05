/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meditnance.client.DAO;

import java.util.List;
import org.hibernate.Session;
import org.meditnance.client.domain.Client;
import org.meditnance.client.domain.Furniture;
import org.meditnance.client.domain.Intervention;
import org.meditnance.client.util.HibernateUtil;

/**
 *
 * @author Talus
 */
public class FurnitureDAO extends org.meditnance.client.DAO.model.FurnitureDAO {
  @Override
  public Furniture getByLastIntervention(Intervention i) {
    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
    s.beginTransaction();
    Furniture f = (Furniture) s.createQuery("from Furniture where lastIntervention.id = " + i.getId()).uniqueResult();
    s.getTransaction().commit();
    s.close();

    return f;
  }

  @Override
  public List<Furniture> getByClient(Client c) {
    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
    s.beginTransaction();
    List<Furniture> l = s.createQuery("from Furniture where client.id = " + c.getId()).list();
    s.getTransaction().commit();
    s.close();

    return l;
  }

  @Override
  public Furniture getById(Integer id) {
    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
    s.beginTransaction();
    Furniture f = (Furniture) s.get(Furniture.class, id);
    s.getTransaction().commit();
    s.close();

    return f;
  }

  @Override
  public List<Furniture> getAll() {
    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
    s.beginTransaction();
    List<Furniture> l = s.createQuery("from Furniture").list();
    s.getTransaction().commit();
    s.close();

    return l;
  }
}
