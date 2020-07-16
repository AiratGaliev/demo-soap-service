package com.github.airatgaliev.demosoapservice.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Envelope")
@XmlAccessorType(XmlAccessType.FIELD)
public class Envelope {

  @XmlElement(name = "FirstName", required = true)
  private String firstName;
  @XmlElement(name = "SecondName", required = true)
  private String secondName;
  @XmlElement(name = "LastName", required = true)
  private String lastName;
  @XmlElement(name = "Income", required = true)
  private Double income;
  @XmlElement(name = "Expenses", required = true)
  private Double expenses;

  public Envelope() {
  }

  public Envelope(String firstName, String secondName, String lastName, Double income,
      Double expenses) {
    this.firstName = firstName;
    this.secondName = secondName;
    this.lastName = lastName;
    this.income = income;
    this.expenses = expenses;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getSecondName() {
    return secondName;
  }

  public void setSecondName(String secondName) {
    this.secondName = secondName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Double getIncome() {
    return income;
  }

  public void setIncome(Double income) {
    this.income = income;
  }

  public Double getExpenses() {
    return expenses;
  }

  public void setExpenses(Double expenses) {
    this.expenses = expenses;
  }
}
