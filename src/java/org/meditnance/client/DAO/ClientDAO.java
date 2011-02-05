/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meditnance.client.DAO;

import org.meditnance.client.DAO.model.DAO;
import java.util.List;
import org.hibernate.Session;
import org.meditnance.client.domain.Client;
import org.meditnance.client.util.HibernateUtil;

/**
 *
 * @author Talus
 */
public class ClientDAO extends DAO<Client> {
  @Override
  public Client getById(Integer id) {
    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
    s.beginTransaction();
    Client c = (Client) s.get(Client.class, id);
    s.getTransaction().commit();
    s.close();

    return c;
  }

  @Override
  public List<Client> getAll() {
    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
    s.beginTransaction();
    List<Client> l = s.createQuery("from Client").list();
    s.getTransaction().commit();
    s.close();

    return l;
  }
}
