/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meditnance.client.DAO.model;

import java.util.List;
import org.meditnance.client.domain.Client;
import org.meditnance.client.domain.Furniture;
import org.meditnance.client.domain.Intervention;

/**
 *
 * @author Talus
 */
public abstract class FurnitureDAO extends DAO<Furniture> {
  public abstract Furniture getByLastIntervention(Intervention i);
  public abstract List<Furniture> getByClient(Client c);
}
