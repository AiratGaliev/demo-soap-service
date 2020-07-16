package com.github.airatgaliev.demosoapservice.config;

import com.github.airatgaliev.demosoapservice.services.EnvelopeServiceImpl;
import javax.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EndpointsConfig {

  private final Bus bus;

  @Autowired
  public EndpointsConfig(Bus bus) {
    this.bus = bus;
  }

  @Bean
  public Endpoint getEnvelopEndpoint() {
    Endpoint endpoint = new EndpointImpl(bus, new EnvelopeServiceImpl());
    endpoint.publish("/Envelope");
    return endpoint;
  }
}