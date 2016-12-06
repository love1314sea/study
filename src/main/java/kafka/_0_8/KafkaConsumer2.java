package kafka._0_8;

/**
 * Created by wushang on 16/10/28.
 */

import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class KafkaConsumer2 {
	private final ConsumerConnector consumer;
	private final String topic;
	private ExecutorService executor;

	public KafkaConsumer2(String a_zookeeper, String a_groupId, String a_topic) {
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
         // 到此ids已经有了,partition也分配了线程
		try {
			Thread.sleep(10000000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<KafkaStream<byte[], byte[]>> streams = consumerMap.get(topic);

		// now launch all the threads
		//
		executor = Executors.newFixedThreadPool(a_numThreads);

		// now create an object to consume the messages
		//
		int threadNumber = 0;
		for (final KafkaStream stream : streams) {
			executor.submit(new ConsumerTest(stream, threadNumber));
			threadNumber++;
		}

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static ConsumerConfig createConsumerConfig(String a_zookeeper, String a_groupId) {
		Properties props = new Properties();
		props.put("zookeeper.connect", a_zookeeper);
		props.put("group.id", a_groupId);
		props.put("zookeeper.session.timeout.ms", "40000");
		props.put("zookeeper.sync.time.ms", "20000");
		props.put("auto.commit.interval.ms", "1000");

		return new ConsumerConfig(props);
	}

	public static void main(String[] args) {

		String zooKeeper = "192.168.1.129";
		String groupId = "q-test";
		String topic = "test01";
		int threads = 4;

		if (args.length > 0) {
			zooKeeper = args[0];
			groupId = args[1];
			topic = args[2];
			threads = Integer.parseInt(args[3]);

		}

		KafkaConsumer2 example = new KafkaConsumer2(zooKeeper, groupId, topic);
		example.run(threads);

		try {
			Thread.sleep(10000000);
		} catch (InterruptedException ie) {

		}
		example.shutdown();
	}
}
