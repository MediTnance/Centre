/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meditnance.client.db;

// -- Table des interventions

import java.sql.Date;
import java.sql.Time;

public class Intervention {
  private Time begin, end;

  private Date date;

  private Integer id, idEmployee, idClient;
  private Integer cost, nature;
  private String annotations;

  // -- Liaisons avec les autres tables
  private Client client;
  private Employee employee;

  // -- Natures possibles (a completer)
  public static Integer N_MAINTENANCE = 0, N_REPAIR = 1;

  public Intervention() {}

  public Intervention(Integer id, Client client, Employee employee, Date date, Time begin, Time end, Integer cost, Integer nature, String annotations) {
    this.begin = begin;
    this.end = end;
    this.date = date;
    this.id = id;
    this.cost = cost;
    this.nature = nature;
    this.annotations = annotations;
    this.client = client;
    this.employee = employee;
  }


  public String getAnnotations() {
    return this.annotations;
  }

  public void setAnnotations(String annotations) {
    this.annotations = annotations;
  }

  public Time getBegin() {
    return this.begin;
  }

  public void setBegin(Time begin) {
    this.begin = begin;
  }

  public Integer getCost() {
    return this.cost;
  }

  public void setCost(Integer cost) {
    this.cost = cost;
  }

  public Date getDate() {
    return this.date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Time getEnd() {
    return this.end;
  }

  public void setEnd(Time end) {
    this.end = end;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getIdClient() {
    return this.idClient;
  }

  public void setIdClient(Integer idClient) {
    this.idClient = idClient;
  }

  public Integer getIdEmployee() {
    return this.idEmployee;
  }

  public void setIdEmployee(Integer idEmployee) {
    this.idEmployee = idEmployee;
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
    this.client = client;
  }

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }
}
