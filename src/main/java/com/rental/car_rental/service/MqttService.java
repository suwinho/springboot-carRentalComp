package com.rental.car_rental.service;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class MqttService {
    private static final String BROKER_URL = "tcp://broker.hivemq.com:1883";

    private static final String CLIENT_ID = "SpringApp_" + UUID.randomUUID().toString();

    public void sendNotification(String topic, String content) {
        try {
            MqttClient client = new MqttClient(BROKER_URL, CLIENT_ID, new MemoryPersistence());
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker...");
            client.connect(connOpts);
            System.out.println("Connected!");
            MqttMessage msg = new MqttMessage(content.getBytes());
            msg.setQos(2);
            client.publish(topic,msg);
            client.disconnect();
        } catch (MqttException error) {
            System.err.println(error.getMessage());
        }
    }
}
