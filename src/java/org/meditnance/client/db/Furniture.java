/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meditnance.client.db;

// -- Table Materiel

import java.sql.Date;

public class Furniture {
  private Integer id, _clientId;
  private String type, brand, ref;
  private Date lastIntervention;
  private Client client;

  //TODO
  // -- delaiVerif ?? Format ? Creation d'une nouvelle structure... ?

  public Furniture() {}

  public Furniture(Integer id, Client client) {
    this.id = id;
    this.client = client;
  }

  public String getBrand() {
    return this.brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getLastIntervention() {
    return this.lastIntervention;
  }

  public void setLastIntervention(Date lastIntervention) {
    this.lastIntervention = lastIntervention;
  }

  public String getRef() {
    return this.ref;
  }

  public void setRef(String ref) {
    this.ref = ref;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Client getClient() {
    return this.client;
  }

  public void setClient(Client client) {
    this.client = client;
    this.client.addFurniture(this);
    this._clientId = client.getId();
  }

  private Integer getClientId() {
    return this._clientId;
  }

  private void setClientId(Integer _clientId) {
    this._clientId = _clientId;
  }
}
