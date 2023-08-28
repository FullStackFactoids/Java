import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;

import java.util.Properties;

public class Sample5 {
    public static void main(String[] args) {
        // Define the configuration settings for the Kafka Streams application
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "uppercase-app");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); // Assuming Kafka is running on localhost:9092

        // Create a StreamsBuilder, which is used to build the topology of the Kafka Streams application
        StreamsBuilder builder = new StreamsBuilder();

        // Define the processing logic
        KStream<String, String> source = builder.stream("input-topic");
        source.mapValues(value -> value.toUpperCase()).to("output-topic");

        // Build and start the Kafka Streams application
        KafkaStreams streams = new KafkaStreams(builder.build(), props);
        streams.start();

        // Add a shutdown hook to gracefully close the Kafka Streams application
        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
    }
}
