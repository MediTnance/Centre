/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meditenance.centre.DAO.model;

import java.util.List;
import org.meditenance.centre.domain.Intervention;
import org.meditenance.centre.domain.Piece;

/**
 *
 * @author Talus
 */
public abstract class PieceDAO extends DAO<Piece> {
  public abstract List<Piece> getByIntervention(Intervention i);
}
