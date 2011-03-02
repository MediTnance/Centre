/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meditenance.centre.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// -- Table Employés
public class Employee extends MeditnanceDomain {
  private Integer role;
  private String lastName, firstName, address, specialization, password;
  private Date birthDate;

  private List<Intervention> interventions = null;

  public Employee() {}

  public Employee(String firstName, String lastName, Integer role) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.role = role;
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

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Date getBirthDate() {
    return this.birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Integer getRole() {
    return this.role;
  }

  public void setRole(Integer role) {
    this.role = role;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastname) {
    this.lastName = lastname;
  }

  public String getSpecialization() {
    return this.specialization;
  }

  public void setSpecialization(String specialization) {
    this.specialization = specialization;
  }
  
  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return this.firstName + " " + this.lastName;
  }
}
