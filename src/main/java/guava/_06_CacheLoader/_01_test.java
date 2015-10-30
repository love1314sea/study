package guava._06_CacheLoader;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;

/**
 * Created by wushang on 15/10/27.
 */
//   http://outofmemory.cn/java/guava/cache/how-to-use-guava-cache
public class _01_test {
    public static void main(String[] args) throws ExecutionException {
        LoadingCache<String, String> loadingCache = CacheBuilder.newBuilder().build(
                new CacheLoader<String, String>() {
                    @Override
                    public String load(String s) throws Exception {
                        return "hello " + s;
                    }
                }
        );
        loadingCache.put("wu","1");
        System.out.println(loadingCache.get("wu"));
        System.out.println(loadingCache.get("zhao"));
    }


}
