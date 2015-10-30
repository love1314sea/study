package 网络编程.Udp;
/*
Udp形式不需要先建立连接；服务端和客户端差不多；没有IO流，通过send、receive
先执行UdpTest2，后执行UdpTest1。 如果先执行UdpTest1，其发送的数据包会丢失。
 */


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpTest1 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();

        String str = "hello world";
        //封装一个数据包，作为消息发送的对象
        DatagramPacket packet = new DatagramPacket(str.getBytes(),str.length(),
                 InetAddress.getByName("localhost"),7000);//目标地址和端口
        socket.send(packet); //发送
        System.out.println("test1 send over---------");

      //  socket = new DatagramSocket(7000); //不要添加这句，添加就接不到返回的消息了。
        byte[] buffer = new byte[1000];//接受消息的字节数组
        DatagramPacket packet2 = new DatagramPacket(buffer,1000);//作为接受消息的数据包
        socket.receive(packet2);
        System.out.println(new String(buffer,0,packet2.getLength()));//能获得接收的数组长度

        socket.close();
    }
}
