package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Set;

/**
 * Created by wushang on 16/7/28.
 */
public class _2_api {

	private String redisHost;
	private int redisPort;

	private Jedis redisClient;

	public _2_api(String redisHost, int redisPort) {
		this.redisHost = redisHost;
		this.redisPort = redisPort;
	}

	public void init() {
		JedisPoolConfig config = new JedisPoolConfig();
		JedisPool jedisPool = new JedisPool(config, redisHost, redisPort);

		redisClient = jedisPool.getResource();
	}

	public void mget(byte[]... keys) throws Exception {
		List<byte[]> list = redisClient.mget(keys);
		System.out.println(list.size());// 如果某个key对应的value不存在,会put一个null
		if (list != null) {
			for(int i=0; i<list.size(); ++i) {
				if(list.get(i)!=null) {
					System.out.println(new String(list.get(i), "UTF-8"));
				}else {
					System.out.println(list.get(i));
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		String redisHost = "192.168.2.23";
		int redisPort = 6379;
		_2_api demo = new _2_api(redisHost, redisPort);
		demo.init();

		demo.mget("hello".getBytes(), "hello2".getBytes());
	}
}
