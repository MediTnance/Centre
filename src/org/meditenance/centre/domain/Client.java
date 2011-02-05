/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meditenance.centre.domain;

// -- Table pour le client

import java.util.ArrayList;
import java.util.List;

public class Client extends MeditnanceDomain {
  private String lastName, firstName, address;

  private List<Intervention> interventions = null;
  private List<Furniture> furnitures = null;

  public Client() {}

  public Client(String firstName, String lastName, String address) {
    this.lastName = lastName;
    this.firstName = firstName;
    this.address = address;
  }

  public List<Intervention> getInterventions() {
    return interventions;
  }

  public void setInterventions(List<Intervention> interventions) {
    this.interventions = interventions;
  }

  public void addIntervention(Intervention i) {
    if (this.interventions == null) {
      this.interventions = new ArrayList<Intervention>();
    }

    this.interventions.add(i);
  }

  public void removeIntervention(Intervention i) {
    if (this.interventions == null) {
      return;
    }

    this.interventions.remove(i);
  }

  public List<Furniture> getFurnitures() {
    return this.furnitures;
  }

  public void setFurnitures(List<Furniture> f) {
    this.furnitures = f;
  }

  public void addFurniture(Furniture f) {
    if (this.furnitures == null) {
      this.furnitures = new ArrayList<Furniture>();
    }

    this.furnitures.add(f);
  }

  public void removeFurniture(Furniture f) {
    if (this.furnitures == null) {
      return;
    }

    this.furnitures.remove(f);
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
}
