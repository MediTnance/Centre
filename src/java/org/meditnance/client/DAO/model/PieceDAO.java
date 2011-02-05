/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meditnance.client.DAO.model;

import java.util.List;
import org.meditnance.client.domain.Intervention;
import org.meditnance.client.domain.Piece;

/**
 *
 * @author Talus
 */
public abstract class PieceDAO extends DAO<Piece> {
  public abstract List<Piece> getByIntervention(Intervention i);
}
