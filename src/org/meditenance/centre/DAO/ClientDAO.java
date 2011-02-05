/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meditenance.centre.DAO;

import org.meditenance.centre.DAO.model.DAO;
import java.util.List;
import org.hibernate.Session;
import org.meditenance.centre.domain.Client;
import org.meditenance.centre.util.HibernateUtil;

/**
 *
 * @author Talus
 */
public class ClientDAO extends DAO<Client> {
  @Override
  public Client getById(Integer id) {
    Session s = HibernateUtil.getSessionFactory().openSession();
    s.beginTransaction();
    Client c = (Client) s.get(Client.class, id);
    s.getTransaction().commit();
    s.close();

    return c;
  }

  @Override
  public List<Client> getAll() {
    Session s = HibernateUtil.getSessionFactory().openSession();
    s.beginTransaction();
    List<Client> l = s.createQuery("from Client").list();
    s.getTransaction().commit();
    s.close();

    return l;
  }

  public Client getByName(String firstName, String lastName) {
    Session s = HibernateUtil.getSessionFactory().openSession();
    s.beginTransaction();
    Client c = (Client) s.createQuery("from Client where firstName = " + firstName + " and lastName = " + lastName).uniqueResult();
    s.getTransaction().commit();
    s.close();

    return c;
  }
}
