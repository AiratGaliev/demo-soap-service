package com.github.airatgaliev.demosoapservice.services;

import com.github.airatgaliev.demosoapservice.entities.Customer;
import com.github.airatgaliev.demosoapservice.payload.CustomerResponse;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService {

  public static final String RESPONSE_STRING_OK = "Чистый доход по клиенту %s %s %s составляет %s рублей!";
  public static final String RESPONSE_STRING_ERROR = "В запросе имеется ошибка: ";
  public static final String RESPONSE_STATUS_OK = "OK";
  public static final String RESPONSE_STATUS_ERROR = "ERROR";

  @Override
  public CustomerResponse getEarnings(Customer customer) {
    CustomerResponse customerResponse = new CustomerResponse();
    String response = "";
    try {
      Customer newCustomer = getValidatedCustomer(customer);
      assert newCustomer != null;
      response = String
          .format(RESPONSE_STRING_OK, newCustomer.getLastName(), newCustomer.getFirstName(),
              newCustomer.getSecondName(),
              earningsCalculate(newCustomer.getIncome(), newCustomer.getExpenses()).toString());
      customerResponse.setResponse(response);
      customerResponse.setResponseStatus(RESPONSE_STATUS_OK);
    } catch (NullPointerException e) {
      response = RESPONSE_STRING_ERROR + "не все поля заполенены";
      customerResponse.setResponse(response);
      customerResponse.setResponseStatus(RESPONSE_STATUS_ERROR);
    }
    return customerResponse;
  }

  private Double earningsCalculate(Double income, Double expenses) {
    return income - expenses;
  }

  private Customer getValidatedCustomer(Customer customer) {
    String firstName = customer.getFirstName().toUpperCase();
    String secondName = customer.getSecondName().toUpperCase();
    String lastName = customer.getLastName().toUpperCase();
    Double income = customer.getIncome();
    Double expenses = customer.getExpenses();
    if (!firstName.equals("") && !secondName.equals("") && !lastName.equals("") && income != null
        && expenses != null) {
      return new Customer(firstName, secondName, lastName, income, expenses);
    }
    return null;
  }
}
