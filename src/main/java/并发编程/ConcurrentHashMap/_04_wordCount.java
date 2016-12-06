package 并发编程.ConcurrentHashMap;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by wushang on 16/9/29.
 */
/*
参考博客:
https://my.oschina.net/mononite/blog/144329?p=1
 */
public class _04_wordCount {
	ConcurrentHashMap<String, Long> wordCountsConMap1 = new ConcurrentHashMap<>();
	ConcurrentHashMap<String, AtomicLong> wordCountsConMap2 = new ConcurrentHashMap<>();
	ConcurrentHashMap<String, Future<ExpensiveObj>> cache = new ConcurrentHashMap<>();


	//1 问题: 使用Long,实现逻辑复杂 2 会重复装箱,拆箱
	public long increase1(String word) {
		Long newValue, oldValue;
		while (true) {//使用while循环,直至成功
			oldValue = wordCountsConMap1.get(word);
			if (oldValue != null) {//已经存在
				newValue = oldValue + 1;
				boolean isSuccess = wordCountsConMap1.replace(word, oldValue, newValue); //CAS 操作,  同时会不断赋新值,性能降低
				if (isSuccess) {
					break;
				}
			} else {//第一次出现
				newValue = 1L;
				if (wordCountsConMap1.putIfAbsent(word, newValue) == null) {
					break;
				}
			}
		}
		return newValue;
	}

	//2 使用AtomicLong 解决了上面两个问题
	// 但仍然存在一个问题:重复创建
	public long increase2(String word) {
		AtomicLong oldValue = wordCountsConMap2.get(word);  //需要使用AtomicLong, 否则不能实现原子操作
		if (oldValue == null) {
			AtomicLong count = new AtomicLong(0);
			oldValue = wordCountsConMap2.putIfAbsent(word, count);//putIfAbsent
			if (oldValue == null) {
				oldValue = count;
			}
		}
		return oldValue.incrementAndGet();
	}
	//3 避免都线程重复创建(与wordCount)不同;如果存在,获取;如果不存在,创建
	public ExpensiveObj get(String s) {
		Future<ExpensiveObj> future = cache.get(s);
		if(future == null) {//不存在
			Callable<ExpensiveObj> callable = new Callable<ExpensiveObj>() {
				@Override
				public ExpensiveObj call() throws Exception {
					return new ExpensiveObj();//
				}
			};
			FutureTask<ExpensiveObj> task = new FutureTask<ExpensiveObj>(callable);
			future = cache.putIfAbsent(s, task);//先放一个封装的Future进去;放进去再运行
			if(future == null) {
				future = task;
				task.run();
			}
		}
		try {
			return future.get();// 阻塞,直到task运行结束
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}


	public static void main(String[] args) throws Exception {

	}
}

class ExpensiveObj {

}