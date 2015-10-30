package 网络编程.Udp;


import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpTest2 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(7000);//监听这个端口，

        byte[] buffer = new byte[1000];
        DatagramPacket packet = new DatagramPacket(buffer,1000);
        System.out.println("test2 1----------");
        socket.receive(packet);
        System.out.println("test2 2----------");
        System.out.println(new String(buffer,0,packet.getLength()));
        System.out.println("test2 receiver over----------");

        //给发送者返回一条消息
        String str = "welcome";
        DatagramPacket packet2 = new DatagramPacket(str.getBytes(), str.length(),
                packet.getAddress(), packet.getPort());//原来接受的数据包中包含有源的ip和port
        socket.send(packet2);

        socket.close();

    }
}
