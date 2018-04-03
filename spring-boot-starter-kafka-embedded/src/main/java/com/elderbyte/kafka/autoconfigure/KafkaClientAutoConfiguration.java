package com.elderbyte.kafka.autoconfigure;

import com.elderbyte.kafka.config.EmbeddedKafkaConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import( { EmbeddedKafkaConfig.class } )
public class KafkaClientAutoConfiguration {

}
