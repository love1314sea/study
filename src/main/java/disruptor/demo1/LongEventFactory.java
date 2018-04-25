package disruptor.demo1;

import com.lmax.disruptor.EventFactory;

/**
 * Created by wushang on 2017/5/1.
 */
// 实现工厂类: to allow the Disruptor to preallocate these events for us
public class LongEventFactory implements EventFactory<LongEvent> {
	@Override
	public LongEvent newInstance() {
		return new LongEvent();
	}
}
