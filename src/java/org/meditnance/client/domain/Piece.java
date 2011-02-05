/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meditnance.client.domain;

// -- Représentation d'une pièce d'un matériel dans la base de données
public class Piece extends MeditnanceDomain {
  String provider, reference;

  private Intervention intervention;

  public Piece(Intervention intervention, String provider, String reference) {
    this.intervention = intervention;
    this.provider = provider;
    this.reference = reference;

    this.intervention.addPiece(this);
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

  public void setIntervention(Intervention intervention) {
    if (this.intervention != null) {
      this.intervention.removePiece(this);
    }

    this.intervention = intervention;
    this.intervention.addPiece(this);
  }

  public Intervention getIntervention() {
    return this.intervention;
  }
}
