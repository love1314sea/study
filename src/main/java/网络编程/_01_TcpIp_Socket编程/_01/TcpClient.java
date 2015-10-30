package 网络编程._01_TcpIp_Socket编程._01;


import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("127.0.0.1", 5000); //立刻向ip+host发起连接

        OutputStream os = socket.getOutputStream();
        os.write("welcome".getBytes());

        InputStream is = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int length = 0;
        System.out.println("1 client-----------");

        while(-1 != (length = is.read(buffer,0,buffer.length))) {
            String str = new String(buffer,0,length);
            System.out.println(str);
        }
        System.out.println("2 client-----------");

        os.close();
        is.close();
        socket.close();
    }
}
