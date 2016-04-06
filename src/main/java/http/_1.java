package http;

import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * Created by wushang on 16/4/6.
 */
public class _1 {
    public static void main(String[] args) throws Exception{
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address.getHostAddress());
        System.out.println(address.getHostName());

        address = InetAddress.getByName("www.163.com");
        System.out.println(address.getHostAddress());
        System.out.println(address.getHostName());

        address = InetAddress.getByName("60.220.196.241");
        System.out.println(address.getHostAddress());
        System.out.println(address.getHostName());

        System.out.println("------------");
        InetSocketAddress address1 = new InetSocketAddress("localhost", 8080);
        System.out.println(address1.getHostName());
        System.out.println(address1.getPort());
        InetAddress inetAddress = address1.getAddress();
        System.out.println(inetAddress.getHostAddress());
        System.out.println(address1.getHostName());
    }
}
