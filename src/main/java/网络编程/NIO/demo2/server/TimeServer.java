package 网络编程.NIO.demo2.server;

/**
 * Created by wushang on 2017/8/14.
 */
public class TimeServer {

	public static void main(String[] args) {
		int port = 8080;

		MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);

		new Thread(timeServer, "NIO-MutiplexerTimeServer-001").start();
	}
}
