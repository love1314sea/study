package zookeeper.分布式锁.demo2;

/**
 * Created by wushang on 16/5/13.
 */
public class Boostrap {
    public static void main(String[] args) throws Exception{
        String ip = "";
        int sessionTimeout = 3000;
        DistributedLock lock = new DistributedLock();
        lock.run(ip, sessionTimeout);
    }
}
