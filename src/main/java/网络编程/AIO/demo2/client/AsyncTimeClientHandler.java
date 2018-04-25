package 网络编程.AIO.demo2.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

/**
 * Created by wushang on 2017/8/14.
 */
public class AsyncTimeClientHandler implements Runnable, CompletionHandler<Void, AsyncTimeClientHandler> {
	private String host;
	private int port;
	private AsynchronousSocketChannel client;

	CountDownLatch latch;

	public AsyncTimeClientHandler(String host, int port) {
		this.host = host;
		this.port = port;
		try {
			client = AsynchronousSocketChannel.open();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		System.out.println("connect:" + host + ":" + port);
		latch = new CountDownLatch(1);
		client.connect(new InetSocketAddress(host, port), this, this);
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void completed(Void result, AsyncTimeClientHandler attachment) {
		System.out.println("client connect successfully");
		byte[] req = "QUERY TIME ORDER".getBytes();
		ByteBuffer writeBuffer = ByteBuffer.allocate(req.length);
		writeBuffer.put(req);
		writeBuffer.flip();//必须转换来发送

		client.write(writeBuffer, writeBuffer, new CompletionHandler<Integer, ByteBuffer>() {
			@Override
			public void completed(Integer result, ByteBuffer attachment) {
				if (attachment.hasRemaining()) {
					client.write(attachment, attachment, this);
				} else {
					//不考虑分包,  暂时认为  一次性读完, 小于1024
					ByteBuffer readBuffer = ByteBuffer.allocate(1024);
					client.read(readBuffer, readBuffer, new CompletionHandler<Integer, ByteBuffer>() {
						@Override
						public void completed(Integer result, ByteBuffer attachment) {
							attachment.flip();
							byte[] bytes = new byte[attachment.remaining()];
							attachment.get(bytes);
							String body = new String(bytes);
							System.out.println("Now is:" + body);
							latch.countDown();
						}

						@Override
						public void failed(Throwable exc, ByteBuffer attachment) {
							exc.printStackTrace();
							try {
								client.close();
								latch.countDown();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					});
				}
			}

			@Override
			public void failed(Throwable exc, ByteBuffer attachment) {
				exc.printStackTrace();
				try {
					client.close();
					latch.countDown();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void failed(Throwable exc, AsyncTimeClientHandler attachment) {
		exc.printStackTrace();
		try {
			client.close();
			latch.countDown();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
