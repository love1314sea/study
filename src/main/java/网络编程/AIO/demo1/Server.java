package 网络编程.AIO.demo1;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Server {
	private static Charset charset = Charset.forName("US-ASCII");
	private static CharsetEncoder encoder = charset.newEncoder();
	
	public static void main(String[] args) throws Exception {

		String att = "zhangsan";
		AsynchronousChannelGroup group = AsynchronousChannelGroup.withThreadPool(Executors.newFixedThreadPool(4));
		final AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open(group).bind(new InetSocketAddress("0.0.0.0", 8013));
		//accept 第一个参数,传递到CompletionHandler中
		server.accept(att, new CompletionHandler<AsynchronousSocketChannel, String>() {
			@Override
			public void completed(AsynchronousSocketChannel result, String attachment) {
				System.out.println("attachment= " + attachment);
				server.accept(null, this); // 接受下一个连接
				try {
					String now = new Date().toString();
					ByteBuffer buffer = encoder.encode(CharBuffer.wrap(now + "\r\n"));
					//result.write(buffer, null, new CompletionHandler<Integer,Void>(){...}); //callback or
					Future<Integer> f = result.write(buffer);
					int i = f.get();

					System.out.println("sent to client: " + now + " size=" + i);
					result.close();
				} catch (IOException | InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
			}

			@Override
			public void failed(Throwable exc, String attachment) {
				exc.printStackTrace();
			}
		});
		System.out.println("hello--");//主线程会执行
		group.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
	}
}