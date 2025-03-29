package FirstProgram;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class OrderProducer {
    public static void main(String args[]) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
        KafkaProducer<String, Integer> producer = new KafkaProducer<String, Integer>(props);
        ProducerRecord<String, Integer> record = new ProducerRecord<>("OrderTopic", "MacBook pro", 10);
        //Fire and Forget
        //producer.send(record);

       try {
       /*     RecordMetadata metaData = producer.send(record).get();
            System.out.println(metaData.partition());
            System.out.println(metaData.offset());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/
           //Async with call back
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
