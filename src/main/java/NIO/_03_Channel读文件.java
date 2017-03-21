package NIO;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by wushang on 16/12/7.
 */
//使用channel的read函数读取文件,并把内容放入到ByteBuffer中(及循环使用byteBuf)
public class _03_Channel读文件 {

	public static void main(String[] args) throws Exception{
		FileInputStream fis = new FileInputStream("/Users/wushang/IdeaProjects/toyprogram/study/src/main/java/NIO/_02_Channel读文件.java");
		FileChannel fc = fis.getChannel();

		ByteBuffer bf = ByteBuffer.allocate(5);

		while (fc.read(bf) != -1) {//使用channel的read函数读取文件
			bf.flip();//由写->读
			while (bf.hasRemaining()) {
				System.out.print((char)bf.get()); //z逐个自己进行读取
			}
			bf.clear();//清空数组, 重新读取填充
		}
	}
}
