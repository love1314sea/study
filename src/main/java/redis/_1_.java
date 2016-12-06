package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by wushang on 16/5/19.
 */
public class _1_ {
    private String ip = "192.168.2.23";
    private int port = 6379;

    //可用连接实例的最大数目，默认值为8；
    //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
    private int maxActive = 1024;

    //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
    private int maxIdle = 200;

    //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
    private int maxWait = 10000;

    private int timeout = 10000;

    //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    private boolean testOnBorrow = true;

    private JedisPool jedisPool = null;

    public void init() {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxActive(maxActive);
            config.setMaxIdle(maxIdle);
            config.setMaxWait(maxWait);
            config.setTestOnBorrow(testOnBorrow);
            jedisPool = new JedisPool(config, ip, port, timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void release(final Jedis jedis) {
        if (jedis != null && jedisPool != null) {
            jedisPool.returnResource(jedis);
        }
    }

    private Jedis getJedis() {
        try {
            if (jedisPool != null) {
                Jedis resource = jedisPool.getResource();
                return resource;
            } else {
                System.out.println("jedisPool is not inited !!!");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void put() {
        Jedis redisClient = getJedis();
        if (redisClient != null) {
            try {
                String key = "mytest";
                String value = "myworld";
                redisClient.setnx(key.getBytes(), value.getBytes());  //
                redisClient.setnx(key, value);  //
            } finally {
                release(redisClient);
            }
        }
    }

    public static void main(String[] args) throws Exception {

    }
}
