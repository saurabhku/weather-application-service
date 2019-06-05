package com.example.weatherapplicationservice.processor;

import com.example.weatherapplicationservice.producer.KafkaProducer;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class WeatherInputProcessor implements Processor {
    @Autowired
    KafkaProducer kafkaProducer;

    @Value("${kafka.output.topic}")
    String topic;

    public void process(Exchange exchange) throws Exception {
        String input =exchange.getIn().getBody(String.class);
        kafkaProducer.sendMessage(input, topic);
    }

}
