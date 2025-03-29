package WithoutPartitionOrManualAssign;

import WithPartitioner.Order;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.internals.Topic;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class OrderConsumer {
    public static void main(String args[]) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "WithPartitioner.OrderDeserializer");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        KafkaConsumer<String, Order> consumer = new KafkaConsumer<String, Order>(props);
        List<TopicPartition> partitionList = new ArrayList<>();
        //partitionList.add(new TopicPartition("OrderPartitionedTopic", 3));
        List<PartitionInfo> partitionInfos = consumer.partitionsFor("OrderPartitionedTopic");

        for (PartitionInfo partitionInfo : partitionInfos) {
            partitionList.add(new TopicPartition("OrderPartitionedTopic", partitionInfo.partition()));
        }
        consumer.assign(partitionList);
        try {
            while (true) {
                ConsumerRecords<String, Order> records = consumer.poll(Duration.ofMillis(20));

                for (ConsumerRecord<String, Order> order : records) {
                    System.out.println("Name >> " + order.key());
                    System.out.println("Customer Name >>" + order.value().getCustomerName());
                    System.out.println("ProductName >>" + order.value().getProductName());
                    System.out.println("Quantity >>" + order.value().getQuantity());
                    System.out.println("Partition >>" + order.partition());
                }
            }
        } finally {
            consumer.close();
        }
    }
}
