package 网络编程.AIO.demo2.client;

/**
 * Created by wushang on 2017/8/14.
 */
public class TimeClient {
	public static void main(String[] args) throws InterruptedException {
		int port = 8080;
		new Thread(new AsyncTimeClientHandler("127.0.0.1", port)).start();
//		Thread.sleep(10000);
	}
}
