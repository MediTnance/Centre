/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meditenance.centre.DAO.model;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.meditenance.centre.domain.MeditnanceDomain;
import org.meditenance.centre.util.HibernateUtil;

/**
 *
 * @author Talus
 */
public abstract class DAO<O> {
  /**
   * Cherche un objet MeditnanceDomain dans la BDD, ayant l'id id
   *
   * @param id ID à rechercher
   * @return O
   */
  public abstract O getById(Integer id);

  /**
   * Récupère l'ensemble des objets dans la BDD
   *
   * @return List<O>
   */
  public abstract List<O> getAll();

  /**
   * Ajoute un objet dans la BDD
   *
   * @param o Objet à ajouter
   */
  public void add(O o) {
    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction t = null;

    try {
      t = s.beginTransaction();

      s.saveOrUpdate(o);
      t.commit();
    } catch (HibernateException ex) {
      System.err.println("Erreur lors de la sauvegarde de l'objet en BDD");
      if (t != null) t.rollback();
    } finally {
      s.close();
    }
  }

  /**
   * Enlève un objet de la BDD
   *
   * @param object Objet à supprimer
   */
  public void remove(O object) {
    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction t = null;

    try {
      t = s.beginTransaction();

      s.delete(object);
      t.commit();
    } catch (HibernateException ex) {
      System.err.println("Erreur lors de la sauvegarde de l'objet en BDD");
      if (t != null) t.rollback();
    } finally {
      s.close();
    }
  }

  /**
   * Vérifie si o est dans la BDD
   *
   * @param o Objet à vérifier
   * @return vrai si il est enregistré, faux sinon
   */
  public Boolean exists(MeditnanceDomain o) {
    return this.getById(o.getId()) != null;
  }
}
