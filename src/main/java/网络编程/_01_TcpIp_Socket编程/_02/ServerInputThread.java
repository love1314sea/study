package 网络编程._01_TcpIp_Socket编程._02;

import java.io.*;
import java.net.Socket;


public class ServerInputThread extends Thread{
    private Socket socket;

    public ServerInputThread(Socket socket) {
        this.socket = socket;
    }
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            byte[] buffer = new byte[1024];

            while(true) {
                int length = is.read(buffer,0,buffer.length);
                System.out.println(new String(buffer,0,length));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
