package com.hackinlumberjack.rabbit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;

@SpringBootApplication
public class RabbitmqExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqExampleApplication.class, args);
	}

  @Bean
  public Queue queue() {
    return new Queue("simple.queue");
  }

  @Bean
  public DirectExchange exchange() {
    return new DirectExchange("simple.exchange");
  }

  @Bean
  public Binding binding(DirectExchange exchange, Queue queue) {
    return BindingBuilder.bind(queue).to(exchange).with("simple.excahnge");
  }
}
