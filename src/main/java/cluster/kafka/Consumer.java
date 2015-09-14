package cluster.kafka;


/**
 * Created by wushang on 15/3/19.
 */

import kafka.consumer.ConsumerIterator;
import kafka.consumer.ConsumerTimeoutException;
import kafka.consumer.KafkaStream;
import kafka.message.MessageAndMetadata;
import scala.collection.script.Message;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Map;

public class Consumer implements Runnable {
    private KafkaStream m_stream;
    private int m_threadNumber;
    ConsumerIterator<byte[], byte[]> it;
    public Consumer(KafkaStream a_stream, int a_threadNumber) {
        m_threadNumber = a_threadNumber;
        m_stream = a_stream;
        it = m_stream.iterator();

    }
    boolean hasNext() {
        try {
            it.hasNext();
            return true;
        } catch (ConsumerTimeoutException e) {
            return false;
        }
    }
    public void run() {

//        ConsumerIterator<byte[], byte[]> it = m_stream.iterator();
//        while (true) {
//            if (!it.hasNext()) {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("no next");
//            } else {
//                System.out.println(new String(it.next().message()));
//            }
//        }

        System.out.println("run---");


        while (hasNext()) {//阻塞函数
            MessageAndMetadata<byte[], byte[]> messag = it.next();
            String message = new String(messag.message());
            System.out.println("------message :" + message);
            System.out.println("-------topic:" + messag.topic());
            System.out.println("-------partition:" + messag.partition());
            System.out.println("---offest:" + messag.offset());
        }
        System.out.println("Shutting down Thread: " + m_threadNumber);
    }
}