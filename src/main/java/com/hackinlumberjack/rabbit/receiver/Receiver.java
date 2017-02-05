package com.hackinlumberjack.rabbit.senders;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.integration.annotation.Payload;

import java.util.Date;

@RabbitListener(queues = "tut.hello")
public class Receiver {

  @RabbitHandler
  public void receive(@Payload String payload) {
    Date currentDateTime = new Date();
    System.out.println(currentDateTime + ": [x] Received " + payload);
  }
}
