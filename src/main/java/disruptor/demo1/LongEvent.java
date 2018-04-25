package disruptor.demo1;

/**
 * Created by wushang on 2017/5/1.
 */
public class LongEvent {
	private long value;

	public void set(long value) {
		this.value = value;
	}

	public long getValue() {
		return value;
	}
}