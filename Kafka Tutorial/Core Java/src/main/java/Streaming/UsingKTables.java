package Streaming;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KGroupedStream;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Produced;

import java.util.Arrays;
import java.util.Locale;
import java.util.Properties;

public class UsingKTables {

    public static void main(String args[]) {
        //Config
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "streams-dataflow-1");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        props.put(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_CONFIG, 0);

        //Toplogy
        StreamsBuilder builder = new StreamsBuilder();
        //both methods are sync functions i.e. does not return new KStream
        KStream<String, String> stream = builder.stream("streams-wordcount-input");

        KGroupedStream<String, String> grpStream = stream.flatMapValues(value ->
                        Arrays.asList(value.toLowerCase(Locale.ROOT).split("\\s"))).
                groupBy((key, value) -> value);
        KTable<String, Long> ktable = grpStream.count();
        ktable.toStream().to("streams-wordcount-output", Produced.with(Serdes.String(), Serdes.Long()));
        Topology topology = builder.build();

        System.out.println(topology.describe());
        //Stream creation
        KafkaStreams streams = new KafkaStreams(topology, props);
        streams.start();

        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
    }
}
