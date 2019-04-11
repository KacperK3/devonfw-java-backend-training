package com.devonfw.app.java.order.general.common.impl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.devonfw.app.java.order.general.common.base.test.OrderServiceRestTestHelper;

@Configuration
public class OrderServiceRestTestConfig {

  @Bean
  public OrderServiceRestTestHelper orderServiceRestTestHelper() {
    OrderServiceRestTestHelper orderServiceRestTestHelper = new OrderServiceRestTestHelper();
    return orderServiceRestTestHelper;
  }

  @Bean
  public RestTemplate restTemplate() {
    RestTemplate restTemplate = new RestTemplate();
    return restTemplate;
  }
}
