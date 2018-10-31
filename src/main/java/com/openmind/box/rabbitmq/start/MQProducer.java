package com.openmind.box.rabbitmq.start;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class MQProducer {

    private static final String QUEUE_NAME = "started";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        for (int i = 0; i < 10; i++) {
            String msg = "rabbit mq, the " + i + " msg sent";
            channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
        }

        channel.close();
        connection.close();
    }
}
