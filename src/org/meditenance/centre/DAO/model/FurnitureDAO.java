/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meditenance.centre.DAO.model;

import java.util.List;
import org.meditenance.centre.domain.Client;
import org.meditenance.centre.domain.Furniture;
import org.meditenance.centre.domain.Intervention;

/**
 *
 * @author Talus
 */
public abstract class FurnitureDAO extends DAO<Furniture> {
  public abstract Furniture getByLastIntervention(Intervention i);
  public abstract List<Furniture> getByClient(Client c);
}
