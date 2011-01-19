/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meditnance.client.db;

// -- Table pour le client

import java.util.HashSet;

public class Client {
  Integer id;
  String lastName, firstName, address;
  HashSet<Furniture> furnitures = new HashSet<Furniture>();

  public Client() {}
  public Client(Integer id, String firstName, String lastName) {
    this.lastName = lastName;
    this.firstName = firstName;
    this.id = id;
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
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

  public void addFurniture(Furniture furniture) {
    this.furnitures.add(furniture);
  }

  public HashSet<Furniture> getFurnitures() {
    return this.furnitures;
  }

  public void removeFurniture(Furniture furniture) {
    this.furnitures.remove(furniture);
  }
}
