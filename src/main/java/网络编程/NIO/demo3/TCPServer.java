package 网络编程.NIO.demo3;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

public class TCPServer {

    private static final int bufferSize = 1024;
    private static final long timeOut = 3000;// 超时时间
    private static final int listenPort = 1993;// 本地监听端口

    public static void main(String[] args) throws Exception {
        Selector selector = Selector.open();
        ServerSocketChannel listenerChannel = ServerSocketChannel.open();// 创建监听通道，专门用来监听指定的本地端口
        listenerChannel.socket().bind(new InetSocketAddress(listenPort));// 将listenerChannel的socket绑定为本地服务器（IP+prot）绑定
        listenerChannel.configureBlocking(false);
        // 将选择器绑定到监听信道,只有非阻塞信道才可以注册选择器.并在注册过程中指出该信道可以进行Accept操作
        SelectionKey k = listenerChannel.register(selector, SelectionKey.OP_ACCEPT);
//         listenerChannel.register(k.selector(), SelectionKey.OP_WRITE );


        TCPProtocolImpl protocol = new TCPProtocolImpl(bufferSize);

        while (true) {
            if (selector.select() == 0) {// 监听注册的通道，当其中有注册的IO时该函数返回（3000ms没有反应返回0），操作可以进行，并添加对应的SelectorKey
                System.out.println("It haven't I/O now, please wait!");
                continue;
            }

            Iterator<SelectionKey> keyIter = selector.selectedKeys().iterator();
            while (keyIter.hasNext()) {
                try {
                    SelectionKey key = keyIter.next();
                    if (key.isAcceptable()) {

                        protocol.handleAccept(key);
                    }
                    if (key.isReadable()) {
                        protocol.handleRead(key);
                    }
                    if (key.isWritable()) {
                        Thread.sleep(1000);
                        protocol.handleWrite(key);
                        System.out.println("isWritable,yes");
                    }
                } catch (IOException e) {
                    keyIter.remove();
                    continue;
                }
                keyIter.remove();
            }
        }
    }
}

class TCPProtocolImpl {
    private int bufferSize;

    public TCPProtocolImpl() {
        super();
    }

    public TCPProtocolImpl(int bufferSize) {
        super();
        this.bufferSize = bufferSize;
    }

    public void handleAccept(SelectionKey key) throws IOException {
        // 返回创建此键的通道，接受客户端建立连接的请求，并返回SocketChannel对象
        SocketChannel clientChannel = ((ServerSocketChannel) key.channel()).accept();
        clientChannel.configureBlocking(false);
        // 将clientChannel注册到服务端的selector中
        //对于已注册Selector的Channel,再次调用就更新注册信息,这里更新了SelectionKey的类型和附件,附件是需要操作的buffer.
        clientChannel.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(bufferSize));
    }

    public void handleRead(SelectionKey key) throws IOException {
        // 获取客户端通信的通道
        SocketChannel clientChannel = (SocketChannel) key.channel();
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        buffer.clear();
        // 从客户端通道读取信息到buffer缓冲区中(并返回读到信息的字节数)
        long bytesRead = clientChannel.read(buffer);
        if (bytesRead == -1) {
            clientChannel.close();
        } else {
            // 将字节转化为为UTF-8的字符串
            String receivedString = Charset.forName("UTF-8").newDecoder().decode(buffer).toString();
            System.out.println("接收到来自：" + clientChannel.socket().getRemoteSocketAddress() + "发来的信息：" + receivedString);
            String msgSendToClient = "已接收到你的信息：" + receivedString + "正在处理中";
            buffer = ByteBuffer.wrap(msgSendToClient.getBytes("UTF-8"));
//            clientChannel.write(buffer);
            // 设置为下一次读取或是写入做准备
            key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        }
    }

    public void handleWrite(SelectionKey key) throws IOException {
        SocketChannel clientChannel = (SocketChannel) key.channel();
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        buffer.flip();
        clientChannel.write(buffer);
        key.interestOps(key.interestOps() & ~SelectionKey.OP_WRITE); //取消 写事件
    }

}


//https://blog.csdn.net/iter_zc/article/details/39291129