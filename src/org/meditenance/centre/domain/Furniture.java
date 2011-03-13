/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meditenance.centre.domain;

// -- Table Materiel

import java.util.Date;


public class Furniture extends MeditnanceDomain {
  private Integer type, verification;
  private String brand, ref;
  
  private Date lastIntervention = null;
  private Client client = null;

  public Furniture() {}

  public Integer getVerification() {
    return verification;
  }

  public void setVerification(Integer verification) {
    this.verification = verification;
  }

  public String getBrand() {
    return this.brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
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

  public Integer getType() {
    return this.type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public Client getClient() {
    return this.client;
  }

  public void setClient(Client client) {
    if (this.client != null) {
      this.client.removeFurniture(this);
    }

    this.client = client;
//    this.client.addFurniture(this);
  }

  @Override
  public String toString() {
    return super.toString() + " : " + this.brand + " : " + this.ref;
  }
}
