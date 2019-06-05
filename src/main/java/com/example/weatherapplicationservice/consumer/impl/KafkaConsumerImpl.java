package com.example.weatherapplicationservice.consumer.impl;

import com.example.weatherapplicationservice.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

@Service
public class KafkaConsumerImpl implements KafkaConsumer {

    @Value("${output.file}")
    String outputFilePath;

    @Override
    @KafkaListener(topics = "${kafka.input.topic}", groupId = "group_id")
    public void consume(String message) throws IOException {
        Files.write(Paths.get(outputFilePath+ LocalDate.now()), message.getBytes());
    }
}
