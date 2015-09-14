package cluster.kafka;

/**
 * Created by wushang on 15/3/19.
 */
import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConsumerGroup {
    private final ConsumerConnector consumer;
    private final String topic;
    private  ExecutorService executor;

    public ConsumerGroup(String a_zookeeper, String a_groupId, String a_topic) {
        consumer = kafka.consumer.Consumer.createJavaConsumerConnector(
                createConsumerConfig(a_zookeeper, a_groupId));
        this.topic = a_topic;
    }

    public void shutdown() {
        if (consumer != null) consumer.shutdown();
        if (executor != null) executor.shutdown();
        try {
            if (!executor.awaitTermination(5000, TimeUnit.MILLISECONDS)) {
                System.out.println("Timed out waiting for consumer threads to shut down, exiting uncleanly");
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted during shutdown, exiting uncleanly");
        }
    }

    public void run(int a_numThreads) {
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put(topic, new Integer(a_numThreads));
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);

        List<KafkaStream<byte[], byte[]>> streams = consumerMap.get(topic);

        // now launch all the threads
        //
        executor = Executors.newFixedThreadPool(a_numThreads);

        // now create an object to consume the messages
        int threadNumber = 0;
        for (final KafkaStream stream : streams) {

            executor.submit(new Consumer(stream, threadNumber));
            threadNumber++;
        }

    }

    private static ConsumerConfig createConsumerConfig(String a_zookeeper, String a_groupId) {
        Properties props = new Properties();
        props.put("zookeeper.connect", a_zookeeper);
        props.put("group.id", a_groupId);
        props.put("zookeeper.session.timeout.ms", "400");
        props.put("zookeeper.sync.time.ms", "200");
//        props.put("auto.commit.interval.ms", "1000");
        props.put("auto.commit.enable", "false");
        props.put("consumer.timeout.ms", "1000");//默认是－1，即一直阻塞
        return new ConsumerConfig(props);
    }

    public static void main(String[] args) {
//        String zooKeeper = args[0];
//        String groupId = args[1];
//        String topic = args[2];
//        int threads = Integer.parseInt(args[3]);

//        String zooKeeper = "10.10.67.100:2181/kafka/dev";
//        String zooKeeper = "track06:2181/kafka/dev";
        String zooKeeper = "localhost:2181";
        String groupId = "group-test";
        String topic = "test01";
        int threads = 1;

        System.out.println("zookeeper = " + zooKeeper);
        System.out.println("groupId = " + groupId);
        System.out.println("topic = " + topic );
        System.out.println("threads = " + threads);

        final ConsumerGroup example = new ConsumerGroup(zooKeeper, groupId, topic);
        example.run(threads);

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                example.shutdown();
                  // FileStatusCache.flush();
            }
        }));
    }
}