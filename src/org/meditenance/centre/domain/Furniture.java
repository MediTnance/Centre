/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meditenance.centre.domain;

// -- Table Materiel

public class Furniture extends MeditnanceDomain {
  private Integer type, verification;
  private String brand, ref;
  
  private Intervention lastIntervention = null;
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

  public Intervention getLastIntervention() {
    return this.lastIntervention;
  }

  public void setLastIntervention(Intervention lastIntervention) {
    if (this.lastIntervention != null) {
      this.lastIntervention.removeFurniture(this);
    }

    this.lastIntervention = lastIntervention;
    this.lastIntervention.addFurniture(this);
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
    this.client.addFurniture(this);
  }

  @Override
  public String toString() {
    return this.brand + " : " + this.ref;
  }
}
