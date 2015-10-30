package 网络编程._01_TcpIp_Socket编程._02;


import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer_2 {

    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        while(true) {
            Socket socket = ss.accept();
            new ServerInputThread(socket).start();
            new ServerOutputThread(socket).start();
        }
    }
}
