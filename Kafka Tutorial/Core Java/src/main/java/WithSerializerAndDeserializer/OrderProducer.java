package WithSerializerAndDeserializer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;

public class OrderProducer {
    public static void main(String args[]) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "WithSerializerAndDeserializer.OrderSerializer");
        KafkaProducer<String, Order> producer = new KafkaProducer<String, Order>(props);
        Order order = new Order("ME", "I Phone", 10);
        ProducerRecord<String, Order> record = new ProducerRecord<>("OrderTopic", order.getCustomerName(), order);
      try {
           producer.send(record, new Callback() {
               @Override
               public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                   System.out.println(recordMetadata.partition());
                   System.out.println(recordMetadata.offset());
               }
           });
       } finally {
           producer.close();
       }
    }
}
