package IO._06_NIO;
/*
使用RandomAccessFile和NIO结合读取文件
自己写的和别人写的，都有一个共同的问题：要求文件最后要有个“\n",否则可能丢失最后一行
 */

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class _04_使用RandomAccessFile和NIO结合读取文件 {
    //自己写的
    public static void outputFile(String fileName) {
        final int BUF_SIZE = 1024;
        final String ENTER = "\n";
        RandomAccessFile accessFile = null;
        FileChannel fileChannel = null;
        try {
            accessFile = new RandomAccessFile(fileName,"rw");
            fileChannel = accessFile.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(BUF_SIZE);
            StringBuffer strBuf = new StringBuffer();
            byte[] bytes = new byte[BUF_SIZE];
            while((fileChannel.read(buffer)) != -1) {
                int length = buffer.position();
               // buffer.rewind();
               // buffer.get(bytes);//把buffer中的复制到bytes中
                //用上面两行或者下面两行
                buffer.flip();//把limit=position，把position置为0
                buffer.get(bytes,0,length); //注意length参数，如果长度不同，报异常java.nio.BufferUnderflowException

                buffer.clear(); //清空缓冲区，但里面的内容仍然存在。limit = capacity

                String temp = new String(bytes, 0, length);//转换成字符串，一定要加length
                int beginIndex = 0;
                int endIndex = 0;
                //以ENTER为分割符，得到每行内容
                while( (endIndex = temp.indexOf(ENTER,beginIndex))!= -1) {
                    String line = temp.substring(beginIndex,endIndex);
                    line = new String(strBuf.toString() + line);//基本上都会有断行
                    System.out.println(line);
                    beginIndex = endIndex + 1;
                    strBuf.delete(0, strBuf.length());
                }

                if(BUF_SIZE == length ) {//如果相同，则未到末尾，可能有断行
                    strBuf.append(temp.substring(beginIndex,temp.length()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                accessFile.close();
                fileChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    //别人写的
    public static void readLogFile(String filePath) {
        int bufSize = 1024;
        File file = new File(filePath);
        RandomAccessFile accessFile = null;
        FileChannel fileChannel = null;
        try {
            accessFile = new RandomAccessFile(file, "r");
            fileChannel = accessFile.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(bufSize);
            String enterStr = "\n";
            byte[] bytes = new byte[bufSize];
            StringBuffer strBuf = new StringBuffer();
            int count = 0;
            while (fileChannel.read(buffer) != -1) {
                int length = buffer.position();
                buffer.rewind();
                buffer.get(bytes);
                buffer.clear();
                String temp = new String(bytes, 0, length);
                int beginIndex = 0;
                int endIndex = 0;
                while ((endIndex = temp.indexOf(enterStr, beginIndex)) != -1) {
                    String line = temp.substring(beginIndex, endIndex);
                    line = new String(strBuf.toString() + line);
                    System.out.println(line);
                    count++;
                    strBuf.delete(0, strBuf.length());
                    beginIndex = endIndex + 1;
                }
                if (length > temp.length()) {
                    strBuf.append(temp.substring(beginIndex,
                            temp.length()));
                } else {
                    strBuf.append(temp.substring(beginIndex, length));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(accessFile);
            IOUtils.closeQuietly(fileChannel);

        }
    }
    public static void main(String[] args) throws Exception{
        outputFile("C:\\Users\\wuguizhu\\Desktop\\sparksql\\cdnlog.txt");

    }
}
