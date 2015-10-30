package 网络编程;


import java.net.InetAddress;

public class _02_ {
    public static void main(String[] args) throws Exception {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address);

        InetAddress address1 = InetAddress.getByName("www.sina.com");
        System.out.println(address1);
    }
}
