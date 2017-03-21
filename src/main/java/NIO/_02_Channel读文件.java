package NIO;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by wushang on 15/12/1.
 */
//使用channel的read函数读取文件,并把内容放入到ByteBuffer中
public class _02_Channel读文件 {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("/Users/wushang/IdeaProjects/toyprogram/study/src/main/java/NIO/_02_Channel读文件.java");
		//得到文件通道
		FileChannel fc = fis.getChannel();
		//分配与文件等大的缓冲区
		ByteBuffer bf = ByteBuffer.allocate((int)fc.size());
		//整个文件内容全部读入缓冲区, 即是内存映射文件
		fc.read(bf);
		System.out.println(fc.size());
		System.out.println(fc.position());
		System.out.print(fc.position(100));

//		bf.rewind();
		bf.flip();//如果 buffer 恰好填充满了,  flip和rewind都可以
		//输出缓冲区中的内容
		while (bf.hasRemaining()) {
			System.out.print((char)bf.get());
		}
	}
}
