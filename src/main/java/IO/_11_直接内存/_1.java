package IO._11_直接内存;

import sun.nio.ch.DirectBuffer;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/**
 * Created by wushang on 17/1/7.
 */
public class _1 {
	public static void main(String[] args) throws Exception {
		ByteBuffer bb = ByteBuffer.allocateDirect(1024*1024*64);
		TimeUnit.SECONDS.sleep(10);

		//清除直接缓存
		((DirectBuffer)bb).cleaner().clean();

		TimeUnit.SECONDS.sleep(10);

		System.out.println("ok");
	}
}
