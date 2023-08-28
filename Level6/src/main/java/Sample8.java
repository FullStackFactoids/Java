import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Sample8 {

    public static void main(String[] args) {
        // Define properties for the Kafka producer
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092"); // Address of your Kafka broker
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        // Create a Kafka producer with the defined properties
        Producer<String, String> producer = new KafkaProducer<>(props);

        try {
            // Send a message to the specified topic
            producer.send(new ProducerRecord<>("topic", "key", "value"));
            System.out.println("Message sent successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to send message.");
        } finally {
            // Close the producer to release resources
            producer.close();
        }
    }
}
