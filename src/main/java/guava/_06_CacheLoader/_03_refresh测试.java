package guava._06_CacheLoader;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wushang on 17/3/21.
 */
public class _03_refresh测试 {



	public static void main(String[] args) throws Exception {
		LoadingCache<String, String> cache = CacheBuilder.newBuilder().concurrencyLevel(2).initialCapacity(1024)
				                                     .maximumSize(2048).build(new TestLoader());

		cache.put("a","b");
		System.out.println(cache.get("a"));
		cache.refresh("a");
		System.out.println(cache.get("a"));

		Thread.sleep(2000);
		System.out.println(cache.get("a"));

	}
}

class TestLoader extends CacheLoader<String, String> {
	@Override
	public String load(String s) throws Exception {
		return "hello " + s + " " + System.currentTimeMillis();
	}

//	@Override  //同步reload
//	public ListenableFuture<String> reload(String key, String oldValue) throws Exception {
//		System.out.println("begin reload-----");
//		Thread.sleep(3000);
//		System.out.println("finish sleep:");
//		return super.reload(key, oldValue);
//
//	}
//
	@Override    //异步reload
	public ListenableFuture<String> reload(String key, String oldValue) throws Exception {
		ExecutorService executor = Executors.newFixedThreadPool(1);
		ListenableFutureTask<String> task = ListenableFutureTask.create(new Callable<String>() {
			public String call() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return "reload ";
			}
		});
		executor.execute(task);
		return task;
	}
}