package zookeeper.分布式锁.选举;

/**
 * Created by wushang on 16/6/15.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderLatch;
import org.apache.curator.retry.ExponentialBackoffRetry;
//import org.apache.curator.test.TestingServer;
import org.apache.curator.retry.RetryUntilElapsed;
import org.apache.curator.utils.CloseableUtils;

import com.google.common.collect.Lists;

public class LeaderLatchExample {
    private static final int CLIENT_QTY = 3;
    private static final String PATH = "/examples/leader";
    private static int zkConnectionTimeout = 3000;
    private final static int ZK_RETRY_INTERVAL = 500;

    public static void main(String[] args) throws Exception {

        List<CuratorFramework> clients = Lists.newArrayList();
        List<LeaderLatch> examples = Lists.newArrayList();
//        TestingServer server = new TestingServer();
        try {
            for (int i = 0; i < CLIENT_QTY; ++i) {
//                CuratorFramework client = CuratorFrameworkFactory.newClient(server.getConnectString(), new ExponentialBackoffRetry(1000, 3));
                CuratorFramework client = CuratorFrameworkFactory.newClient("127.0.0.1", new ExponentialBackoffRetry(1000, 3));

                CuratorFrameworkFactory.builder()
                        .connectString("127.0.0.1")
//                        .namespace(ZNODE_ANY_ID_NAMESPACE)
                        .retryPolicy(new RetryUntilElapsed(zkConnectionTimeout, ZK_RETRY_INTERVAL))
                        .connectionTimeoutMs(zkConnectionTimeout)
                        .build();
                clients.add(client);
                LeaderLatch example = new LeaderLatch(client, PATH, "Client #" + i);
                examples.add(example);
                client.start();
                example.start();
            }

            Thread.sleep(20000);

            LeaderLatch currentLeader = null;
            for (int i = 0; i < CLIENT_QTY; ++i) {
                LeaderLatch example = examples.get(i);
                if (example.hasLeadership())
                    currentLeader = example;
            }
            System.out.println("current leader is " + currentLeader.getId());
            System.out.println("release the leader " + currentLeader.getId());
            currentLeader.close();
            examples.get(0).await(2, TimeUnit.SECONDS);
            System.out.println("Client #0 maybe is elected as the leader or not although it want to be");
            System.out.println("the new leader is " + examples.get(0).getLeader().getId());

            System.out.println("Press enter/return to quit\n");
            new BufferedReader(new InputStreamReader(System.in)).readLine();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Shutting down...");
            for (LeaderLatch exampleClient : examples) {
                CloseableUtils.closeQuietly(exampleClient);
            }
            for (CuratorFramework client : clients) {
                CloseableUtils.closeQuietly(client);
            }
//            CloseableUtils.closeQuietly(server);
        }
    }
}