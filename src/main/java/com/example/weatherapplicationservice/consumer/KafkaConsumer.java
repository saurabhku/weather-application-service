package com.example.weatherapplicationservice.consumer;

import java.io.IOException;

public interface KafkaConsumer {
    public void consume(String message) throws IOException;
}

