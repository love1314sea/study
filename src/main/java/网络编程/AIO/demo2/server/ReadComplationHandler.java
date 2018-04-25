package 网络编程.AIO.demo2.server;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.Date;

/**
 * Created by wushang on 2017/8/13.
 */

/*
1 需要对半包消息做处理: 在此不考虑
2 write 的时候,注意 ByteBuffer 的先flip
3 如果所有数据没有完全发送完, 在回调函数中 继续发送.
 */
public class ReadComplationHandler implements CompletionHandler<Integer, ByteBuffer> {

	private AsynchronousSocketChannel channel;

	public ReadComplationHandler(AsynchronousSocketChannel channel) {
		this.channel = channel;
	}

	@Override
	public void completed(Integer result, ByteBuffer attachment) {

		attachment.flip(); //由写转读

		byte[] body = new byte[attachment.remaining()];

		System.out.println("result = " + result + ", remaining=" + attachment.remaining()); // 是相等的
		attachment.get(body);

		try {
			String req = new String(body, "UTF-8");
			System.out.println("The time server receive ord:" + req);

			String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(req) ? new Date(System.currentTimeMillis()).toString() : "BAD ORDER";

			doWrite(currentTime);
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	@Override
	public void failed(Throwable exc, ByteBuffer attachment) {
		try {
			channel.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void doWrite(String currentTime) {
		if (currentTime != null) {
			byte[] bytes = currentTime.getBytes();
			final ByteBuffer writerBuffer = ByteBuffer.allocate(bytes.length);
			writerBuffer.put(bytes);
			writerBuffer.flip(); //发送的时候,如果不转换,会报错吗?? 必须转换, 否则,没有数据发出
			channel.write(writerBuffer, writerBuffer, new CompletionHandler<Integer, ByteBuffer>() {
				@Override
				public void completed(Integer result, ByteBuffer attachment) {
					if (attachment.hasRemaining()) { //如果没有发送完成, 继续发送.
						channel.write(attachment, attachment, this);
					}
				}

				@Override
				public void failed(Throwable exc, ByteBuffer attachment) {
					try {
						channel.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
}
