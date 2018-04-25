package 网络编程.AIO.demo2.server;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * Created by wushang on 2017/8/13.
 */
public class AcceptCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, AsyncTimeServerHander> {

	@Override
	public void completed(AsynchronousSocketChannel result, AsyncTimeServerHander attachment) {
		////result 是 连接客户端的关键. read, write(向客户端)
		System.out.println("receive a client");
		attachment.asynchronousServerSocketChannel.accept(attachment, this);
		ByteBuffer buffer = ByteBuffer.allocate(1024);

		//read也是异步的,经过回调函数
		result.read(buffer, buffer, new ReadComplationHandler(result));
	}

	@Override
	public void failed(Throwable exc, AsyncTimeServerHander attachment) {
		exc.printStackTrace();
	}
}


