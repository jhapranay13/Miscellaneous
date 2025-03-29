package FirstProgram;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.Properties;

public class OrderConsumer {
    public static void main(String args[]) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.IntegerDeserializer");
        props.put("group.id", "OrderGroup");

        KafkaConsumer<String, Integer> consumer = new KafkaConsumer<String, Integer>(props);
        consumer.subscribe(Collections.singletonList("OrderTopic"));
        try {
            while (true) {
                ConsumerRecords<String, Integer> records = consumer.poll(Duration.ofMillis(20));

                for (ConsumerRecord<String, Integer> order : records) {
                    System.out.println("Name >> " + order.key());
                    System.out.println("Quantity >>" + order.value());
                }
            }
        } finally {
            consumer.close();
        }
    }
}
