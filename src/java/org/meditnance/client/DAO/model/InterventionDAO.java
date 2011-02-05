/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meditnance.client.DAO.model;

import java.util.List;
import org.meditnance.client.domain.Client;
import org.meditnance.client.domain.Employee;
import org.meditnance.client.domain.Intervention;

/**
 *
 * @author Talus
 */
public abstract class InterventionDAO extends DAO<Intervention> {
  public abstract List<Intervention> getByEmployee(Employee e);
  public abstract List<Intervention> getByClient(Client c);
}
