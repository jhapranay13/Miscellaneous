package ConsumerGroupSpecial;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.*;

public class OrderConsumer {
    public static void main(String args[]) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "ConsumerGroupSpecial.OrderDeserializer");
        props.put("group.id", "OrderGroup");
       // props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false"); // by default commit happens every 5 seconds
        // props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "500");
        props.put("auto.commit.offset", "false");
        props.put(ConsumerConfig.FETCH_MIN_BYTES_CONFIG, "1024");
        props.put(ConsumerConfig.FETCH_MAX_WAIT_MS_CONFIG, "500");
        props.put(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG, "200");
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "3000"); // If heartbeat is not send by this then the co ordinator will consider this as dead
        props.put(ConsumerConfig.MAX_PARTITION_FETCH_BYTES_CONFIG, "1MB"); //Data per partition
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest"); // latest earliest
        props.put(ConsumerConfig.CLIENT_ID_CONFIG, "Order consumer"); // used by broker for logging Metrix etc
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "12"); // Number of max records to fetch for each poll
        props.put(ConsumerConfig.PARTITION_ASSIGNMENT_STRATEGY_CONFIG, RangeAssignor.class.getName()); // RoundrobinAssigner

        KafkaConsumer<String, Order> consumer = new KafkaConsumer<String, Order>(props);
        Map<TopicPartition, OffsetAndMetadata> partiotionAndOffset = new HashMap<>();

        class RebalanceHandler implements ConsumerRebalanceListener {

            @Override
            public void onPartitionsRevoked(Collection<TopicPartition> collection) {
                consumer.commitSync(partiotionAndOffset);
            }

            @Override
            public void onPartitionsAssigned(Collection<TopicPartition> collection) {

            }
        }
        consumer.subscribe(Collections.singletonList("OrderPartitionedTopic"), new RebalanceHandler());
        try {
            while (true) {
                ConsumerRecords<String, Order> records = consumer.poll(Duration.ofMillis(20));
                int count = 0;

                for (ConsumerRecord<String, Order> order : records) {
                    System.out.println("Name >> " + order.key());
                    System.out.println("Customer Name >>" + order.value().getCustomerName());
                    System.out.println("ProductName >>" + order.value().getProductName());
                    System.out.println("Quantity >>" + order.value().getQuantity());
                    System.out.println("Partition >>" + order.partition());
                    partiotionAndOffset.put(new TopicPartition(order.topic(), order.partition()),
                            new OffsetAndMetadata(order.offset() + 1));
                    if (count % 10 == 0) {
                        // Custom
                        consumer.commitAsync(partiotionAndOffset,
                                new OffsetCommitCallback() {
                                    @Override
                                    public void onComplete(Map<TopicPartition, OffsetAndMetadata> map, Exception e) {

                                        if (e != null) {
                                            System.out.println("Commmit failed for offsets >>" + map);
                                        }
                                    }
                                });
                    }
                    count++;
                }
              /*  //consumer.commitSync();  //retries if fails
                consumer.commitAsync(new OffsetCommitCallback() {
                    @Override
                    public void onComplete(Map<TopicPartition, OffsetAndMetadata> map, Exception e) {

                        if (e != null) {
                            System.out.println("Commmit failed for offsets >>" + map);
                        }
                    }
                }); // retries won't happen for Async

               */
            }
        } finally {
            consumer.close();
        }
    }
}
