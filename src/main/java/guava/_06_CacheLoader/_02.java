package guava._06_CacheLoader;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import sun.misc.Cache;

import java.util.concurrent.ExecutionException;

/**
 * Created by wushang on 15/12/21.
 */
public class _02 {
    public static void main(String[] args) throws ExecutionException {
        LoadingCache<String, String> loadingCache = CacheBuilder.newBuilder().build(
                new CacheLoader<String, String>() {
                    @Override
                    public String load(String s) throws Exception {
                        return "hello " + s;
                    }

                    @Override
                    public ListenableFuture<String> reload(String key, String oldValue) throws Exception {
                        System.out.println("reloading -------");
                        System.out.println("oldvalue = " + oldValue);
                        return Futures.immediateFuture("last");
                    }
                });
        loadingCache.put("zhang" , " 12");
        System.out.println(loadingCache.get("wu"));
        System.out.println(loadingCache.get("zhang"));
        loadingCache.refresh("zhang");// refresh 会调用reload， reload的新值替换旧值
        System.out.println(loadingCache.get("zhang"));


        loadingCache.refresh("li");// refresh 一个不存在的key， 没有任何反应，不会调用reload
        System.out.println(loadingCache.get("li"));



    }
}
