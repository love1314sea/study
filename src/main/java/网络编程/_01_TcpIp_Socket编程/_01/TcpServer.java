package 网络编程._01_TcpIp_Socket编程._01;


import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss  = new ServerSocket(5000);
        Socket socket = ss.accept(); // 阻塞等待客户端连接

        InputStream is = socket.getInputStream();
        byte[] buffer = new byte[1024];

        is.read(buffer);
        System.out.println(new String(buffer));

      /*  int length = 0;  //为什么这段代码就会卡住？
        while(-1 != (length = is.read(buffer,0,buffer.length))) { //read也是阻塞函数
            String str = new String(buffer,0,length);
            System.out.println(str);
            System.out.println("test----------");
        }*/

        System.out.println("1 server--------");
        OutputStream os = socket.getOutputStream();
        os.write("hello world".getBytes());
        System.out.println("2 server--------");

        is.close();
        os.close();
        socket.close();

    }
}
