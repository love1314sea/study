package disruptor.demo1;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by wushang on 2017/5/1.
 */
public class LongEventMain {

	public static void main(String[] args) throws InterruptedException {
		Executor executor = Executors.newCachedThreadPool();
		LongEventFactory factory = new LongEventFactory();
		int bufferSize = 1024;

		Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(factory, bufferSize, executor);
		disruptor.handleEventsWith(new LongEventHandler());
		disruptor.start();

		RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
		LongEventProducer producer = new LongEventProducer(ringBuffer);
		while (true) {
			producer.onData();
			Thread.sleep(100);
		}
	}
}
