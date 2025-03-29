package WithoutPartitionOrManualAssign;

import WithPartitioner.Order;
import WithPartitioner.PartitionToUse;
import org.apache.kafka.clients.producer.*;

import java.util.Properties;

public class OrderProducer {
    public static void main(String args[]) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "WithPartitioner.OrderSerializer");

        KafkaProducer<String, Order> producer = new KafkaProducer<String, Order>(props);
        Order order = new Order("Sam", "I Phone", 10);
        ProducerRecord<String, Order> record = new ProducerRecord<>("OrderPartitionedTopic", order.getCustomerName(), order);
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
