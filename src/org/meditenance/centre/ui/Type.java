/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meditenance.centre.ui;

/**
 * Types d'intervention
 *
 * @author Talus
 */
public enum Type {
  MAINTENANCE(0),
  BREAK(1);

  private int type;

  private Type(int type) {
    this.type = type;
  }

  public int getType() {
    return this.type;
  }

  @Override
  public String toString() {
    String types[] = {"Maintenance", "Réparation"};

    return types[this.type];
  }
}
