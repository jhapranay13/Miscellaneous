package WithTransactions;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class OrderConsumer {
    public static void main(String args[]) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "WithTransactions.OrderDeserializer");
        props.put("group.id", "OrderGroup");

        KafkaConsumer<String, Order> consumer = new KafkaConsumer<String, Order>(props);
        consumer.subscribe(Collections.singletonList("OrderTopic"));
        try {
            while (true) {
                ConsumerRecords<String, Order> records = consumer.poll(Duration.ofMillis(20));

                for (ConsumerRecord<String, Order> order : records) {
                    System.out.println("Name >> " + order.key());
                    System.out.println("Quantity >>" + order.value().getCustomerName());
                    System.out.println("Quantity >>" + order.value().getProductName());
                }
            }
        } finally {
            consumer.close();
        }
    }
}
