package com.example.activemq.client;

import org.apache.activemq.ActiveMQConnectionFactory;
import jakarta.jms.*;

/**
 * A Simple example that connects to the ActiveMQ broker with Jakarta Messaging 3.1, send and receive message
 */
public class JakartaMessagingReceiveBodyExample implements Example {

    private final static String WIRE_LEVEL_ENDPOINT = "<Connection URL>";
    private final static String ACTIVE_MQ_USERNAME = "<username>";
    private final static String ACTIVE_MQ_PASSWORD = "<password>";

    public void run() throws JMSException {
        // Create a connection factory.
        final ActiveMQConnectionFactory connectionFactory =
            new ActiveMQConnectionFactory(WIRE_LEVEL_ENDPOINT);
        // Pass the sign-in credentials.
        connectionFactory.setUserName(ACTIVE_MQ_USERNAME);
        connectionFactory.setPassword(ACTIVE_MQ_PASSWORD);

        // Send a message
        try (JMSContext context = connectionFactory.createContext();) {
            context.createProducer().send(context.createQueue("MyQueueV3")," Hello, welcome to ActiveMQ using JMS 3.1!");
            JMSConsumer consumer = context.createConsumer(context.createQueue("MyQueueV3"));
            String text = consumer.receiveBody(String.class);
            System.out.println("Message: " + text);
        }
    }
}