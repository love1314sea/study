package 并发编程.BlockingQueue.demo2;

import java.io.File;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by wushang on 15/6/18.
 */
/*
计算目录大小
 */
public class ConcurrentTotalFileSizeWQueue {
    private ExecutorService service;
    final private BlockingQueue<Long> fileSizes = new ArrayBlockingQueue<Long>(500);//有界
    final AtomicLong pendingFileVisits = new AtomicLong();

    //递归的使用
    private void startExploreDir(final File file) {
        pendingFileVisits.incrementAndGet();
        service.execute(new Runnable() {
            public void run() {
                exploreDir(file);
            }
        });
    }
    private void exploreDir(final File file) {
        System.out.println(file.toString());
        long fileSize = 0;
        if(file.isFile())
            fileSize = file.length();
        else {
            final File[] children = file.listFiles();
            if(children != null) {
                for(final File child : children) {
                    if(child.isFile())
                        fileSize += child.length();
                    else
                        startExploreDir(child);
                }
            }
        }
        try {
            fileSizes.put(fileSize);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        pendingFileVisits.decrementAndGet();
    }

    private long getTotalSizeOfFile(final String fileName) throws InterruptedException {
        service = Executors.newFixedThreadPool(10);
        try {
            startExploreDir(new File(fileName));

            long totalSize = 0;
            while (pendingFileVisits.get() > 0 || fileSizes.size() > 0) { //pendingFileVisits 起到一个条件阻塞作用,像CountDownLatch
                final long size = fileSizes.poll(10, TimeUnit.SECONDS);//poll函数取出
                totalSize += size;
            }
            return totalSize;
        }finally {
            service.shutdown();
        }
    }

    public static void main(final String[] args) throws InterruptedException {
        final long start = System.nanoTime();
        final long total = new ConcurrentTotalFileSizeWQueue().getTotalSizeOfFile("/Users/wushang/Work/百度云同步盘");
        final long end = System.nanoTime();
        System.out.println("total size =" + total);
        System.out.println("Time token:" + (end-start)/1.0e9);
    }
}
