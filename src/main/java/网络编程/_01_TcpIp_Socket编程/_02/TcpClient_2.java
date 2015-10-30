package 网络编程._01_TcpIp_Socket编程._02;

import java.net.Socket;


public class TcpClient_2 {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 5000);
        new ClientInputThread(socket).start();
        new ClientOutputThread(socket).start();
    }
}
//http://wh.meituan.com/deal/26592646.html?acm=UmyulwbWk_2132205963452330601.26592646.11&mtt=1.s%2Fdefault.0.0.i65uwsmv&cks=23631#anchor-reviews