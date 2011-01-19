/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meditnance.client.db;

import java.sql.Date;

// -- Table Employés
public class Employee {
  private Integer id, role;
  private String lastname, firstName, address, specialization;
  private Date birthDate;

  // -- roles -- a completer
  public static Integer
    ADMIN = 0,
    TECHNICIAN = 1,
    PAWN = 2;

  public Employee() {}
  public Employee(Integer id, String firstName, String lastName, Integer role) {
    this.id = id;
    this.firstName = firstName;
    this.lastname = lastName;
    this.role = role;
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

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getLastname() {
    return this.lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getSpecialization() {
    return this.specialization;
  }

  public void setSpecialization(String specialization) {
    this.specialization = specialization;
  }
}
