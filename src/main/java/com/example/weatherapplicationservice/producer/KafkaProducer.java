package com.example.weatherapplicationservice.producer;

public interface KafkaProducer {

    public void sendMessage(String message, String topicName);
}
