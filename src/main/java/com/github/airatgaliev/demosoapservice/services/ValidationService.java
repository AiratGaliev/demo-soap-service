package com.github.airatgaliev.demosoapservice.services;

import com.github.airatgaliev.demosoapservice.exceptions.InvalidStringException;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

  private static final String STRING_PATTERN = "\\p{L}+";
  private static final String DOUBLE_PATTERN = "(\\.|\\d)+";

  public void validateStringValue(String checkedString) {
    if (checkedString.trim().isEmpty()) {
      throw new InvalidStringException("не все поля заполнены");
    }

    if (!checkedString.trim().matches(STRING_PATTERN)) {
      throw new InvalidStringException("вы ввели неверное значение " + checkedString);
    }
  }

  public void validateParseDoubleValue(String checkedString) {
    if (checkedString.trim().isEmpty()) {
      throw new InvalidStringException("не все поля заполнены");
    }
    if (!checkedString.trim().matches(DOUBLE_PATTERN)) {
      throw new InvalidStringException("вы ввели неверное значение " + checkedString);
    }
  }
}
