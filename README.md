 [ ![Download](https://api.bintray.com/packages/elderbyte/maven/spring-boot-starter-kafka-embedded/images/download.svg) ]
 (https://bintray.com/elderbyte/maven/spring-boot-starter-kafka-embedded/_latestVersion)

# spring-boot-starter-kafka-embedded
Provides spring auto configuration for an embedded Kafka message broker.

## Configuration

Configure the embedded kafka broker in your apps `application.yml`
```yaml
# Embedded Kafka Broker
kafka.embedded:
  enabled: true
  port: 9092
  partitions: 1
```

When this starter is on the class-path, the broker will automatically get started. 
To disable the broker, set the `kafka.embedded.enabled` property to `false`.
