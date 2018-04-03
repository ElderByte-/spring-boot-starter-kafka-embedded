package com.elderbyte.kafka.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.test.rule.KafkaEmbedded;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Configures and starts an embedded Kafka Server.
 */
@Configuration
@ConditionalOnProperty(value = "kafka.embedded.enabled", matchIfMissing = true)
public class EmbeddedKafkaConfig {

    /***************************************************************************
     *                                                                         *
     * Fields                                                                  *
     *                                                                         *
     **************************************************************************/

    private static final Logger log = LoggerFactory.getLogger(EmbeddedKafkaConfig.class);

    @Value("${kafka.embedded.port:9092}")
    public int kafkaPort;

    @Value("${kafka.embedded.partitions:1}")
    public int partitions;

    private KafkaEmbedded embedded;

    /***************************************************************************
     *                                                                         *
     * Event hooks                                                             *
     *                                                                         *
     **************************************************************************/

    @PostConstruct
    public void startKafka(){

        log.info("Starting embedded kafka ...");

        try {
            embedded = new KafkaEmbedded(1, false, partitions);
            embedded.setKafkaPorts(kafkaPort);
            embedded.before();
            log.info("Embedded Kafka ready!");
        }catch (Exception e){
            log.error("Failed to start embedded kafka!", e);

        }
    }

    @PreDestroy
    public void stopKafka(){
        embedded.after();
    }
}
