/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meditenance.centre.domain;

// -- Table des interventions

import java.util.ArrayList;
import java.util.List;

public class Intervention extends MeditnanceDomain {
  private String begin, end;

  private Integer cost, nature;
  private String annotations;

  // -- Liaisons avec les autres tables
  private Client client = null;
  private Employee employee = null;
  private List<Piece> pieces = null;

  public Intervention() {}

  public Intervention(Client client, Employee employee, Integer cost, Integer nature, String annotations) {
//    this.begin = new Date();
    this.cost = cost;
    this.nature = nature;
    this.annotations = annotations;
    this.client = client;
    this.employee = employee;

    this.client.addIntervention(this);
  }

  public List<Piece> getPieces() {
    return pieces;
  }

  public void setPieces(List<Piece> pieces) {
    this.pieces = pieces;
  }

  public void addPiece(Piece piece) {
    if (this.pieces == null) this.pieces = new ArrayList<Piece>();

    this.pieces.add(piece);
  }

  public void removePiece(Piece p) {
    if (this.pieces == null) return;

    this.pieces.remove(p);
  }

  public String getAnnotations() {
    return this.annotations;
  }

  public void setAnnotations(String annotations) {
    this.annotations = annotations;
  }

  public String getBegin() {
    return this.begin;
  }

  public void setBegin(String begin) {
    this.begin = begin;
  }

  public Integer getCost() {
    return this.cost;
  }

  public void setCost(Integer cost) {
    this.cost = cost;
  }

  public String getEnd() {
    return this.end;
  }

  public void setEnd(String end) {
    this.end = end;
  }

  public Integer getNature() {
    return this.nature;
  }

  public void setNature(Integer nature) {
    this.nature = nature;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    if (this.client != null) {
      this.client.removeIntervention(this);
    }

    this.client = client;
    this.client.addIntervention(this);
  }

  public Employee getEmployee() {
    return this.employee;
  }

  public void setEmployee(Employee employee) {
    if (this.employee != null) {
      this.employee.removeIntervention(this);
    }
    
    this.employee = employee;

    if (this.employee != null) {
      this.employee.addIntervention(this);
    }
  }

  @Override
  public String toString() {
//    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    String str = "Intervention du " + this.begin;
    
    if (this.end != null) {
      str += " au " + this.end;
    }

    return super.toString() + " : " + str;
  }
}
