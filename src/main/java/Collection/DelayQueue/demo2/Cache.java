//package Collection.DelayQueue.demo2;
//
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.ConcurrentMap;
//import java.util.concurrent.DelayQueue;
//
///**
// * Created by wushang on 2017/4/14.
// */
//public class Cache<K, V> {
//
//	private DelayQueue<DelayedItem> queue = new DelayQueue<>();
//	private ConcurrentMap<K, V> map = new ConcurrentHashMap<K, V>();
//
//	public void put(K k, V v, long liveTime) {
//		V v2 = map.put(k,v);
//		DelayedItem item = new DelayedItem()
//		if(v2 != null) {
//
//		}
//	}
//}
