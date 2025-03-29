package ConsumerGroupSpecial;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;

public class OrderProducer {
    public static void main(String args[]) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "ConsumerGroupSpecial.OrderSerializer");
        props.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, PartitionToUse.class.getName());
        props.put(ProducerConfig.ACKS_CONFIG, "all"); // 0 -> If message fails it is lost 1 -> Only if leader replica recives message or all -> if all the replica recives message
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, "345676"); // by default 256 MB
        props.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, "gzip"); // snappy -> high CP gzip -> high compressiomn
        props.put(ProducerConfig.RETRIES_CONFIG, "2");
        props.put(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, "500");
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, "1024");// in bytes
        props.put(ProducerConfig.LINGER_MS_CONFIG, "200"); // milliseconds to wait till batch fill up but if it does not message is set
        props.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, "200"); // milliseconds to wait till batch fill up but if it does not message is set
        props.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true"); // Broker assign ID and Mesages are sequnced. So same message is rejected
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
