package com.github.airatgaliev.demosoapservice.entities;

import java.text.DecimalFormat;

public class Customer {

  private String firstName;
  private String secondName;
  private String lastName;
  private Double income;
  private Double expenses;

  public Customer() {
  }

  public Customer(String firstName, String secondName, String lastName, Double income,
      Double expenses) {
    this.firstName = firstName;
    this.secondName = secondName;
    this.lastName = lastName;
    this.income = Double.parseDouble(new DecimalFormat(".##").format(income));
    this.expenses = Double.parseDouble(new DecimalFormat(".##").format(expenses));
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
    this.income = Double.parseDouble(new DecimalFormat(".##").format(income));
  }

  public Double getExpenses() {
    return expenses;
  }

  public void setExpenses(Double expenses) {
    this.expenses = Double.parseDouble(new DecimalFormat(".##").format(expenses));
  }
}
