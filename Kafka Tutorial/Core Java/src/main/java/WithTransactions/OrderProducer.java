package WithTransactions;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;

public class OrderProducer {
    public static void main(String args[]) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "WithTransactions.OrderSerializer");
        props.put(ProducerConfig.TRANSACTIONAL_ID_CONFIG, "new-transaction-1"); // If there are multiple Instances of producer running this ID should be different for all of them
        props.put(ProducerConfig.MAX_BLOCK_MS_CONFIG, "1000"); // if till then the transaction is not completed then it will be timeout
        KafkaProducer<String, Order> producer = new KafkaProducer<String, Order>(props);
        producer.initTransactions();
        Order order = new Order("ME", "I Phone", 10);
        Order order2 = new Order("You", "Mac book", 20);
        ProducerRecord<String, Order> record = new ProducerRecord<>("OrderTopic", order.getCustomerName(), order);
        ProducerRecord<String, Order> record2 = new ProducerRecord<>("OrderTopic", order.getCustomerName(), order);

        try {
            producer.beginTransaction();
           producer.send(record);
           producer.send(record2);
           producer.commitTransaction();
       } catch(Exception e) {
            producer.abortTransaction();
        }finally {
           producer.close();
       }

        // if you want to take commit into your own hands then group id must be provided. if not will get exception
    }
}
