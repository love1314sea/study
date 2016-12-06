package zookeeper.分布式锁.demo2;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by wushang on 16/5/13.
 */

/*
/*
分布式锁: 多台机器上的进程处理共享的资源
每个线程在目录下面创建一个顺序临时节点(为什么必须使用临时节点? 否则,万一一个进程崩溃,那在zk中的节点就不会被删除了)
检查自己是不是最小的:如果是,则访问共享资源.
如果不是最小的,则构建监控关系: 监控次小于自己的.(构建监控关系,可能存在失败的情况;一瞬间,上个任务完成了,临时节点删除,需要检查)
 */
public class DistributedLock implements Watcher {
    private CountDownLatch countDownLatch = new CountDownLatch(1);
    private static final String GROUP_PATH = "/disLocks";
    private static final String SUB_PATH = "/disLocks/sub";
    private String lockPath;
    private String waitPath;
    ZooKeeper zooKeeper;

    public void run(String ip, int sessionTimeout) throws Exception {
        try {
            zooKeeper = new ZooKeeper(ip, sessionTimeout, this);//this对象, run肯定是DistributedLock 对象来调用
            countDownLatch.await();
            createPath();
            if (checkMinPath()) {
                getLockSuccess();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void createPath() {

        try {
            lockPath = zooKeeper.create(SUB_PATH, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //获得锁,访问共享资源
    private void getLockSuccess() throws KeeperException, InterruptedException {
        if (zooKeeper.exists(this.lockPath, false) == null) {
            return;
        }
        Thread.sleep(2000);
        zooKeeper.delete(lockPath, -1); // 删除路径
        releaseConnection(); //释放连接
    }

    public void releaseConnection() {
        if (this.zooKeeper != null) {
            try {
                this.zooKeeper.close();
            } catch (InterruptedException e) {
            }
        }
    }

    private boolean checkMinPath() throws Exception {
        List<String> subNodes = zooKeeper.getChildren(GROUP_PATH, null);
        Collections.sort(subNodes);
        int index = subNodes.indexOf(lockPath.substring(GROUP_PATH.length() + 1));
        if (index == -1) {
            System.err.println("节点不存在");
            return false;
        } else if (index == 0) {
            return true;
        } else {
            this.waitPath = GROUP_PATH + "/" + subNodes.get(index - 1);
            try {
                zooKeeper.getData(waitPath, true, new Stat()); //可能在设置的时候,恰好节点被删除了或发生异常
                return false;
            } catch (KeeperException e) {
                if (zooKeeper.exists(waitPath, false) == null) { //如果是节点被删除了,则重新来一遍
                    return checkMinPath();
                } else {
                    throw e;
                }
            }
        }
    }

    public void process(WatchedEvent event) {
        if (event == null) return;

        Event.KeeperState keeperState = event.getState();
        Event.EventType eventType = event.getType();
        if (keeperState == Event.KeeperState.SyncConnected) {
            if (Event.EventType.None == eventType) {
                System.out.println("成功连接上ZK服务器");
                countDownLatch.countDown();  // 释放latch
            } else if (Event.EventType.NodeDeleted == eventType && event.getPath().equals(waitPath)) {
                System.out.println("收到情报，排我前面的家伙已挂，我是不是可以出山了？");
                try { //为什么再检查一次? 自己监控的节点被删除,可能存在其他原因导致被删掉:如它的连接中断,进程退出等.
                    // 再检查一次,避免资源竞争
                    if (checkMinPath()) {
                        getLockSuccess();
                    }
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (keeperState == Event.KeeperState.Disconnected) {
            System.out.println("与ZK服务器断开连接");
        } else if (Event.KeeperState.AuthFailed == keeperState) {
            System.out.println("权限检查失败");
        } else if (Event.KeeperState.Expired == keeperState) {
            System.out.println("会话失效");
        }
    }
}
