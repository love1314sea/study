package disruptor.demo1;

import com.lmax.disruptor.RingBuffer;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wushang on 2017/5/1.
 */
public class LongEventProducer {

	private static AtomicInteger i = new AtomicInteger(1);
	private final RingBuffer<LongEvent> ringBuffer;

	public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
		this.ringBuffer = ringBuffer;
	}

	public void onData() {

		long sequence = ringBuffer.next();//claim the slot
		try {
			LongEvent event = ringBuffer.get(sequence);
			event.set(i.getAndIncrement());

		} finally {
			ringBuffer.publish(sequence); // 在finally中发布
		}
	}
}
