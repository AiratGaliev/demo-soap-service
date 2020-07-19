package com.github.airatgaliev.demosoapservice.services;

import com.github.airatgaliev.demosoapservice.entities.Customer;
import com.github.airatgaliev.demosoapservice.exceptions.InvalidStringException;
import com.github.airatgaliev.demosoapservice.payload.CustomerRequest;
import com.github.airatgaliev.demosoapservice.payload.CustomerResponse;
import java.text.DecimalFormat;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService {

  private static final String RESPONSE_STRING_OK = "Чистый доход по клиенту %s %s %s составляет %s рублей!";
  private static final String RESPONSE_STRING_ERROR = "В запросе имеется ошибка: ";
  private static final String RESPONSE_STATUS_OK = "OK";
  private static final String RESPONSE_STATUS_ERROR = "ERROR";

  @Override
  public CustomerResponse getEarnings(CustomerRequest customerRequest) {
    CustomerResponse customerResponse = new CustomerResponse();
    String response = "";
    try {
      Customer newCustomer = getValidatedCustomer(customerRequest);
      response = String
          .format(RESPONSE_STRING_OK, newCustomer.getLastName().toUpperCase(),
              newCustomer.getFirstName().toUpperCase(), newCustomer.getSecondName().toUpperCase(),
              earningsCalculate(newCustomer.getIncome(), newCustomer.getExpenses()).toString());
      customerResponse.setResponse(response);
      customerResponse.setResponseStatus(RESPONSE_STATUS_OK);
    } catch (InvalidStringException | NullPointerException e) {
      response = RESPONSE_STRING_ERROR + e.getMessage();
      customerResponse.setResponse(response);
      customerResponse.setResponseStatus(RESPONSE_STATUS_ERROR);
    }
    return customerResponse;
  }

  private Double earningsCalculate(Double income, Double expenses) {
    return Double.parseDouble(new DecimalFormat(".##").format(income - expenses));
  }

  private Customer getValidatedCustomer(CustomerRequest customerRequest)
      throws InvalidStringException {
    String firstNameString = customerRequest.getFirstName();
    String secondNameString = customerRequest.getSecondName();
    String lastNameString = customerRequest.getLastName();
    String incomeString = customerRequest.getIncome();
    String expensesString = customerRequest.getExpenses();
    Double income = Double.parseDouble(incomeString);
    Double expenses = Double.parseDouble(expensesString);
    ValidationService validationService = new ValidationService();
    validationService.validateStringValue(firstNameString);
    validationService.validateStringValue(secondNameString);
    validationService.validateStringValue(lastNameString);
    validationService.validateParseDoubleValue(incomeString);
    validationService.validateParseDoubleValue(expensesString);
    return new Customer(firstNameString, secondNameString, lastNameString, income, expenses);
  }
}
