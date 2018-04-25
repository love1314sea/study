package 网络编程.AIO.demo2.server;

/**
 * Created by wushang on 2017/8/13.
 */
public class TimeServer {
	public static void main(String[] args) throws Exception{
		int port = 8080;
		AsyncTimeServerHander timeServerHander = new AsyncTimeServerHander(port);
		new Thread(timeServerHander, "AIO-AsyncTimeServerHandler-001").start();
		System.out.println("main thread over");
	}
}
