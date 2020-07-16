package com.github.airatgaliev.demosoapservice.services;

import com.github.airatgaliev.demosoapservice.payload.EnvelopeRequest;
import com.github.airatgaliev.demosoapservice.payload.EnvelopeResponse;
import org.springframework.stereotype.Service;

@Service
public class EnvelopeServiceImpl implements IEnvelopeService {

  public static final String RESPONSE_STRING = "Чистый доход по клиенту %s %s %s составляет %s рублей!";

  @Override
  public EnvelopeResponse getEarnings(EnvelopeRequest envelopeRequest) {
    String firstName = envelopeRequest.getFirstName().toUpperCase();
    String secondName = envelopeRequest.getSecondName().toUpperCase();
    String lastName = envelopeRequest.getLastName().toUpperCase();
    Double income = envelopeRequest.getIncome();
    Double expenses = envelopeRequest.getExpenses();
    EnvelopeResponse envelopeResponse = new EnvelopeResponse();
    String response = String.format(RESPONSE_STRING, lastName, firstName, secondName,
        earningsCalculate(income, expenses).toString());
    envelopeResponse.setResponse(response);
    envelopeResponse.setResponseStatus("OK");
    return envelopeResponse;
  }

  private Double earningsCalculate(Double income, Double expenses) {
    return income - expenses;
  }
}
