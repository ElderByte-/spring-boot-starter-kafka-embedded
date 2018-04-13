package com.elderbyte.example.demo;


import com.elderbyte.kafka.EnableEmbeddedKafka;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import java.net.UnknownHostException;


@EnableEmbeddedKafka
@SpringBootApplication
public class EmbeddedKafkaServer {

    private static final Logger log = LoggerFactory.getLogger(EmbeddedKafkaServer.class);

    public static void main(String[] args) throws UnknownHostException {
        ApplicationContext ctx = SpringApplication.run(EmbeddedKafkaServer.class, args);

        Environment env = ctx.getEnvironment();

        log.info("Embedded Kafka Server ready!");
    }
}