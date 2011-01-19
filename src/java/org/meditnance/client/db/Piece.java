/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meditnance.client.db;

// -- Représentation d'une pièce d'un matiériel dans la base de données
public class Piece {
  Integer id, idIntervention;
  String provider, reference;

  private Intervention intervention;

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getProvider() {
    return this.provider;
  }

  public void setProvider(String provider) {
    this.provider = provider;
  }

  public String getReference() {
    return this.reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public Integer getIdIntervention() {
    return idIntervention;
  }

  public void setIdIntervention(Integer idIntervention) {
    this.idIntervention = idIntervention;
  }

  public void setIntervention(Intervention intervention) {
    this.intervention = intervention;
    this.idIntervention = intervention.getId();
  }

  public Intervention getIntervention() {
    return this.intervention;
  }
}
