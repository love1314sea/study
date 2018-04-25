//中
//IO:学习 http://wiki.jikexueyuan.com/project/blockchain/truffle-introduction-development.html
package IO._06_NIO;


import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.RandomAccess;

public class _02_Demo {
    public static void main(String[] args) throws Exception{
        RandomAccessFile aFile = new RandomAccessFile("/Users/wushang/IdeaProjects/toyprogram/study/src/main/java/IO/_06_NIO/_02_Demo.java","rw");
        RandomAccessFile bFile = new RandomAccessFile("/Users/wushang/IdeaProjects/toyprogram/study/src/main/java/IO/_06_NIO/_02_Demo2.java","rw");
        FileChannel inChannel = aFile.getChannel();
        FileChannel bChannel = bFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = inChannel.read(buf);//从channal中read到buf
        while(bytesRead != -1 ) {
            System.out.println("Read " + bytesRead);
            buf.flip();
            while(buf.hasRemaining()){
                System.out.print((char) buf.get() );//按字节读取
            }
//            bChannel.write(buf);
            buf.clear();
            bytesRead = inChannel.read(buf);//重新read
        }
        aFile.close();

        InetSocketAddress address = new InetSocketAddress("kfk1", 9092);

        if(address.isUnresolved()) {
            System.out.println("hello");
        }else {
            System.out.println("world");
        }

    }
}
