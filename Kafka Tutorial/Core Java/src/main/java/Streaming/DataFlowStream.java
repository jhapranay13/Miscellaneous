package Streaming;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;

import java.util.Locale;
import java.util.Properties;

public class DataFlowStream {

    public static void main(String args[]) {
        //Config
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "streams-dataflow");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        //Toplogy
        StreamsBuilder builder = new StreamsBuilder();
        //both methods are sync functions i.e. does not return new KStream
        KStream<String, String> stream = builder.stream("streams-dataflow-input");
        stream.foreach((key, value) -> System.out.println("KEY >> " + key + " Value >> " + value));
        // Return new stream
        // You can create new key and value as well. So key can also be used as value
        KStream<String, String> newStream = stream.filter((key, value) ->
                value.contains("token")).mapValues(value -> value.toUpperCase(Locale.ROOT));
        //stream.to("streams-dataflow-output");
        newStream.to("streams-dataflow-output");
        Topology topology = builder.build();

        System.out.println(topology.describe());
        //Stream creation
        KafkaStreams streams = new KafkaStreams(topology, props);
        streams.start();

        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
    }
}
