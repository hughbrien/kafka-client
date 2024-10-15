

Start Up Sequences for Kafka 

First
bin/zookeeper-server-start.sh config/zookeeper.properties


bin/kafka-console-consumer.sh --topic test --from-beginning --bootstrap-server localhost:9092


bin/kafka-console-producer.sh --topic test --bootstrap-server localhost:9092


# Create a topic
kafka-topics.sh --create --topic my-topic --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1

# List all topics
kafka-topics.sh --list --bootstrap-server localhost:9092

# Describe a topic
kafka-topics.sh --describe --topic my-topic --bootstrap-server localhost:9092

# List all consumer groups
kafka-consumer-groups.sh --list --bootstrap-server localhost:9092

# Describe a specific consumer group
kafka-consumer-groups.sh --describe --group my-group --bootstrap-server localhost:9092