package 网络编程._01_TcpIp_Socket编程._02;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * Created by wuguizhu on 2015/2/15.
 */
public class ClientInputThread extends Thread{
    private Socket socket;

    public ClientInputThread(Socket socket) {
        this.socket = socket;
    }
    public void run() {
        try {
            InputStream is = socket.getInputStream();

            byte[] buffer = new byte[1024];
            while(true) {
                int length = is.read(buffer,0,buffer.length);//阻塞，且返回值为读取长度
                System.out.println(new String(buffer,0,length));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
