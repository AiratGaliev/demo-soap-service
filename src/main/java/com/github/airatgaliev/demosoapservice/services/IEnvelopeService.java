package com.github.airatgaliev.demosoapservice.services;

import com.github.airatgaliev.demosoapservice.entities.Envelope;
import com.github.airatgaliev.demosoapservice.payload.EnvelopeResponse;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

@WebService(name = "IPersonService")
public interface IEnvelopeService {

  @WebMethod
  EnvelopeResponse getEarnings(@XmlElement(required = true) Envelope envelop);
}

