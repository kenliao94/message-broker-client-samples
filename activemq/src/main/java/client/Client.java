package com.example.activemq.client;

import jakarta.jms.*;


public class Client {
    public static void main(String[] args) throws JMSException {
        Example example = new JakartaMessagingSendAndReceiveExample();
        example.run();
    }
}