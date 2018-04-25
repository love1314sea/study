package disruptor.demo1;


import com.lmax.disruptor.EventHandler;

/**
 * Created by wushang on 2017/5/1.
 */
public class LongEventHandler implements EventHandler<LongEvent> {

	@Override
	public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
		System.out.println("event :" + longEvent.getValue());
	}
}