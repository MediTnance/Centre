/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meditenance.centre.domain;

// -- Table des interventions

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Intervention extends MeditnanceDomain {
  private Date begin, end;

  private Integer cost, nature;
  private String annotations;

  // -- Liaisons avec les autres tables
  private Client client = null;
  private Employee employee = null;
  private List<Piece> pieces = null;
  private List<Furniture> furnitures = null;

  // -- Natures possibles (a completer)
  public final static Integer N_MAINTENANCE = 0, N_REPAIR = 1;

  public Intervention() {}

  public Intervention(Client client, Employee employee, Integer cost, Integer nature, String annotations) {
    this.begin = new Date();
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
    this.pieces.add(piece);
  }

  public void removePiece(Piece p) {
    this.pieces.remove(p);
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

  public String getAnnotations() {
    return this.annotations;
  }

  public void setAnnotations(String annotations) {
    this.annotations = annotations;
  }

  public Date getBegin() {
    return this.begin;
  }

  public void setBegin(Date begin) {
    this.begin = begin;
  }

  public Integer getCost() {
    return this.cost;
  }

  public void setCost(Integer cost) {
    this.cost = cost;
  }

  public Date getEnd() {
    return this.end;
  }

  public void setEnd(Date end) {
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
    this.employee.addIntervention(this);
  }

  @Override
  public String toString() {
    DateFormat df = DateFormat.getDateInstance();

    String str = "Intervention du " + df.format(this.begin);
    
    if (this.end != null) {
      str += " au " + df.format(this.end);
    }

    return str;
  }
}
