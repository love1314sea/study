package Collection.DelayQueue.demo2;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by wushang on 2017/4/14.
 *
 */
/*
http://www.cnblogs.com/sunzhenchao/p/3515085.html
1 向DelayedQueue中放置的元素(封装了真正要保存的数据单元), 必须是吸纳Delayed接口
2 每次put的时候
 */
public class DelayedItem<T> implements Delayed {
	private T t;
	private long liveTime;

	private long removeTime;

	public DelayedItem(T t, long liveTime) {
		this.t = t;
		this.liveTime = liveTime;
		//根据当前时间+存活时间,计算得到删除的时间戳
		this.removeTime = TimeUnit.NANOSECONDS.convert(liveTime, TimeUnit.NANOSECONDS) + System.nanoTime();
	}

	@Override
	public int compareTo(Delayed o) {
		if(o == null) return 1;
		if(o == this) return 0;

		return 0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		return unit.convert(removeTime - System.nanoTime(), unit);//距离多长时间,转换为指定单位
	}
}
