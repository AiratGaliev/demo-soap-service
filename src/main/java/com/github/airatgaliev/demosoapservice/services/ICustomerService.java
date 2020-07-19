package com.github.airatgaliev.demosoapservice.services;

import com.github.airatgaliev.demosoapservice.payload.CustomerRequest;
import com.github.airatgaliev.demosoapservice.payload.CustomerResponse;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

@WebService(name = "IPersonService")
public interface ICustomerService {

  @WebMethod
  CustomerResponse getEarnings(@XmlElement(required = true) CustomerRequest customerRequest);
}

