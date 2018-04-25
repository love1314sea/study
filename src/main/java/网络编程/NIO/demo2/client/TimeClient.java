package 网络编程.NIO.demo2.client;

/**
 * Created by wushang on 2017/8/14.
 */
public class TimeClient {
	public static void main(String[] args) {
		int port = 8080;
		new Thread(new TimeClientHandler("127.0.0.1", port)).start();
	}
}
