/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meditenance.centre.domain;

/**
 * Toutes les classes du Domain hérite de celle-ci
 *
 * @author Talus
 */
public class MeditnanceDomain {
  private Integer id;

  public MeditnanceDomain() {}

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "#" + this.id;
  }
}
