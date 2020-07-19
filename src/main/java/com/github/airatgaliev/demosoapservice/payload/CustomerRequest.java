package com.github.airatgaliev.demosoapservice.payload;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerRequest {

  @XmlElement(name = "FirstName", required = true)
  private String firstName;
  @XmlElement(name = "SecondName", required = true)
  private String secondName;
  @XmlElement(name = "LastName", required = true)
  private String lastName;
  @XmlElement(name = "Income", required = true)
  private String income;
  @XmlElement(name = "Expenses", required = true)
  private String expenses;

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

  public String getIncome() {
    return income;
  }

  public void setIncome(String income) {
    this.income = income;
  }

  public String getExpenses() {
    return expenses;
  }

  public void setExpenses(String expenses) {
    this.expenses = expenses;
  }
}
