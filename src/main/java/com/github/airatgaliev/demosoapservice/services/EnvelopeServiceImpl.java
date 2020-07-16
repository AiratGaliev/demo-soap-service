package com.github.airatgaliev.demosoapservice.services;

import com.github.airatgaliev.demosoapservice.entities.Envelope;
import com.github.airatgaliev.demosoapservice.payload.EnvelopeResponse;
import org.springframework.stereotype.Service;

@Service
public class EnvelopeServiceImpl implements IEnvelopeService {

  public static final String RESPONSE_STRING_OK = "Чистый доход по клиенту %s %s %s составляет %s рублей!";
  public static final String RESPONSE_STRING_ERROR = "В запросе имеется ошибка: ";
  public static final String RESPONSE_STATUS_OK = "OK";
  public static final String RESPONSE_STATUS_ERROR = "ERROR";

  @Override
  public EnvelopeResponse getEarnings(Envelope envelope) {
    EnvelopeResponse envelopeResponse = new EnvelopeResponse();
    String response = "";
    try {
      Envelope newEnvelope = getValidatedEnvelope(envelope);
      assert newEnvelope != null;
      response = String
          .format(RESPONSE_STRING_OK, newEnvelope.getLastName(), newEnvelope.getFirstName(),
              newEnvelope.getSecondName(),
              earningsCalculate(newEnvelope.getIncome(), newEnvelope.getExpenses()).toString());
      envelopeResponse.setResponse(response);
      envelopeResponse.setResponseStatus(RESPONSE_STATUS_OK);
    } catch (NullPointerException e) {
      response = RESPONSE_STRING_ERROR + "не все поля заполенены";
      envelopeResponse.setResponse(response);
      envelopeResponse.setResponseStatus(RESPONSE_STATUS_ERROR);
    }
    return envelopeResponse;
  }

  private Double earningsCalculate(Double income, Double expenses) {
    return income - expenses;
  }

  private Envelope getValidatedEnvelope(Envelope envelope) {
    String firstName = envelope.getFirstName().toUpperCase();
    String secondName = envelope.getSecondName().toUpperCase();
    String lastName = envelope.getLastName().toUpperCase();
    Double income = envelope.getIncome();
    Double expenses = envelope.getExpenses();
    if (!firstName.equals("") && !secondName.equals("") && !lastName.equals("") && income != null
        && expenses != null) {
      return new Envelope(firstName, secondName, lastName, income, expenses);
    }
    return null;
  }
}
