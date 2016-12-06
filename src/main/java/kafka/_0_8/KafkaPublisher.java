package kafka._0_8;

import com.networkbench.mq.MessageQueuePublishException;
import com.networkbench.mq.kafka.KafkaMQPublisher;


/**
 * Created by wushang on 16/9/28.
 */
public class KafkaPublisher {

	private KafkaMQPublisher kafkaPublisher;

	public KafkaPublisher() {

		kafkaPublisher = new KafkaMQPublisher();
		kafkaPublisher.setServers("192.168.1.129:9092");
		try {
			kafkaPublisher.start();
		} catch (MessageQueuePublishException e) {
			e.printStackTrace();
		}
	}

	public void pulish() throws Exception{
		kafkaPublisher.publish("q-newlens-mobile-app-crash-index", "abc");
	}

	public static void main(String[] args) throws Exception {
		KafkaPublisher publisher = new KafkaPublisher();
		publisher.pulish();
	}
}
