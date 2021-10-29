package sample.embeddedkafka

import net.manub.embeddedkafka.{EmbeddedKafka, EmbeddedKafkaConfig}
import org.slf4j.LoggerFactory

object KafkaBroker extends App with EmbeddedKafka {
  val log = LoggerFactory.getLogger(this.getClass)

  val port = 9092
  val stateTopic = "state"
  val eventsTopic = "events"
  val partitions = 16

  implicit val config: EmbeddedKafkaConfig = EmbeddedKafkaConfig(kafkaPort = port)
  val server = EmbeddedKafka.start()

  createCustomTopic(topic = stateTopic, partitions = partitions)
  createCustomTopic(topic = eventsTopic, partitions = partitions)

  log.info(s"Kafka running: localhost:$port")
  log.info(s"Topic '$stateTopic' with $partitions partitions created")
  log.info(s"Topic '$eventsTopic' with $partitions partitions created")

  server.broker.awaitShutdown()
}