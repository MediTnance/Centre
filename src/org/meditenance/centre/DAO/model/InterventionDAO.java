/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meditenance.centre.DAO.model;

import java.util.Date;
import java.util.List;
import org.meditenance.centre.domain.Client;
import org.meditenance.centre.domain.Employee;
import org.meditenance.centre.domain.Intervention;

/**
 *
 * @author Talus
 */
public abstract class InterventionDAO extends DAO<Intervention> {
  public abstract List<Intervention> getByEmployee(Employee e);
  public abstract List<Intervention> getByClient(Client c);
  public abstract List<Intervention> getByClientAndEmployee(Client c, Employee e);
  public abstract List<Intervention> getByDate(Date date);
}
