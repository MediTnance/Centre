/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meditenance.centre.ui;

/**
 *
 * @author Talus
 */
public enum Role {
  ADMIN(0),
  TECHNICIAN(1),
  OPERATOR(2);

  private int role;

  private Role(int role) {
    this.role = role;
  }

  public int getRole() {
    return this.role;
  }

  @Override
  public String toString() {
    String roles[] = {"Administrateur", "Technicien", "Opérateur"};
    return roles[this.role];
  }
}
