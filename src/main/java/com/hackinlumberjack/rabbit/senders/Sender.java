package com.hackinlumberjack.rabbit.senders;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.scheduling.annotation.Scheduled;

public class Sender {
  @Autowired
  private RabbitTemplate rabbitTemplate;

  @Autowired
  private DirectExchange exchange;

  @Scheduled(fixedDelay = 1000, initialDelay = 500)
  public void send() {
    this.rabbitTemplate.convertAndSend(exchange.getName(), "simple", "Hello World");
  }
}
