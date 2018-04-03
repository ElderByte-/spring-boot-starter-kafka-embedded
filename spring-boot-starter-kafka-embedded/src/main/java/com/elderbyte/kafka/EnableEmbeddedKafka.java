package com.elderbyte.kafka;

import com.elderbyte.kafka.config.EmbeddedKafkaConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import( { EmbeddedKafkaConfig.class } )
public @interface EnableEmbeddedKafka {

}
