/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meditnance.client.DAO;

import java.util.List;
import org.hibernate.Session;
import org.meditnance.client.domain.Intervention;
import org.meditnance.client.domain.Piece;
import org.meditnance.client.util.HibernateUtil;

/**
 *
 * @author Talus
 */
public class PieceDAO extends org.meditnance.client.DAO.model.PieceDAO {
  @Override
  public List<Piece> getByIntervention(Intervention i) {
    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
    s.beginTransaction();
    List<Piece> l = s.createQuery("from Piece where intervention.id = " + i.getId()).list();
    s.getTransaction().commit();
    s.close();

    return l;
  }

  @Override
  public Piece getById(Integer id) {
    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
    s.beginTransaction();
    Piece p = (Piece) s.get(Piece.class, id);
    s.getTransaction().commit();
    s.close();

    return p;
  }

  @Override
  public List<Piece> getAll() {
    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
    s.beginTransaction();
    List<Piece> l = s.createQuery("from Piece").list();
    s.getTransaction().commit();
    s.close();

    return l;
  }
}
