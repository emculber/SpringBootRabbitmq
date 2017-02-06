package com.hackinlumberjack.rabbit.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.messaging.handler.annotation.Payload;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RabbitListener(queues = "simple.queue")
public class Receiver {

  @RabbitHandler
  public void receive(@Payload String payload) {
    System.out.println(" [x] [" + new Date() + "] Received " + payload);
  }
}
