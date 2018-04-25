package jmx.MXBean;

/**
 * Created by wushang on 2017/3/27.
 */
public interface QueueSamplerMXBean {
	public QueueSample getQueueSample();

	public void clearQueue();
}