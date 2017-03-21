package guava._06_CacheLoader;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Created by wushang on 15/10/27.
 */
//   http://outofmemory.cn/java/guava/cache/how-to-use-guava-cache
public class _01_test {
	public static void main(String[] args) throws ExecutionException {
		LoadingCache<String, String> loadingCache = CacheBuilder.newBuilder().maximumSize(1).build(
				new CacheLoader<String, String>() {
					@Override
					public String load(String s) {
						System.out.println("new load:" + s);
						return "hello " + s;
					}

					@Override
					public Map<String, String> loadAll(Iterable<? extends String> keys) throws Exception {
						Map<String, String> map = new HashMap<String, String>();
						for (String k : keys) {
//							map.put(k, "all:" + k);
							map.put(k, this.load(k));
						}
						return map;
					}
				}
		);
		loadingCache.put("wu", "1");
		System.out.println(loadingCache.get("wu"));
		System.out.println(loadingCache.get("zhao"));
		System.out.println(loadingCache.get("zhao"));
		System.out.println(loadingCache.get("wu"));

		System.out.println("-----------");

		List<String> list = new ArrayList<>();
		list.add("wu");
		list.add("li");
		list.add("zhao");
		Map<String,String> map = loadingCache.getAll(list);

		for(Map.Entry<String,String> entry : map.entrySet()) {
			String k = entry.getKey();
			String v = entry.getValue();

			System.out.println("k=" + k + ", v=" + v);
		}

		System.out.println("hello".equals(null));
	}


}
