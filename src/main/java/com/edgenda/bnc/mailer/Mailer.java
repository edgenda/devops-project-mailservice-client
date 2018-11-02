package com.edgenda.bnc.mailer;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Mailer {

  private final static String QUEUE_NAME = "emails";

  private final ConnectionFactory factory;

  public Mailer(String host, int port) {
    factory = new ConnectionFactory();
    factory.setHost(host);
    factory.setPort(port);
  }

  public void send(Email email) throws IOException, TimeoutException {
    final String emailJson = email.toJson();
    try (final Connection connection = factory.newConnection()) {
      final Channel channel = connection.createChannel();
      channel.basicPublish("", QUEUE_NAME, null, emailJson.getBytes());
    }
  }
}
