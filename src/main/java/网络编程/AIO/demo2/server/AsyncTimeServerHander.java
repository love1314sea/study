package 网络编程.AIO.demo2.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * Created by wushang on 2017/8/13.
 */
/*
重点: 1 使用CountDownLatch 来阻塞线程
2
 */
public class AsyncTimeServerHander implements Runnable {
	private int port;
	CountDownLatch latch;
	AsynchronousServerSocketChannel asynchronousServerSocketChannel;

	public AsyncTimeServerHander(int port) {
		this.port = port;
		try {
			asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
			asynchronousServerSocketChannel.bind(new InetSocketAddress(port));
			System.out.println("Thre time server is start in port:" + port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void doAccept() {
		asynchronousServerSocketChannel.accept(this, new AcceptCompletionHandler() );
	}

	@Override
	public void run() {
		latch = new CountDownLatch(1);
		doAccept();
		try {
			latch.await(); //用于线程的阻塞   如果不发生错误,服务端会一直阻塞
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
