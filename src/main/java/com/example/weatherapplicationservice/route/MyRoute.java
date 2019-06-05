package com.example.weatherapplicationservice.route;

import com.example.weatherapplicationservice.processor.WeatherInputProcessor;
import com.example.weatherapplicationservice.producer.KafkaProducer;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;



@Component
public class MyRoute extends RouteBuilder {

    @Autowired
    Processor processor;

    @Value("${input.file}")
    String inputFile;
    @Override
    public void configure() throws Exception {
        from("file:"+inputFile+"?delete=true")
                .process(processor);
    }
}