package protobuf.demo2;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.google.protobuf.Descriptors;
import com.google.protobuf.DynamicMessage;

import java.io.FileDescriptor;
import java.io.IOException;

/**
 * Created by wushang on 16/4/1.
 */
public class _1 {
    public static void main(String[] args) throws Exception {
        Codec<SimpleTypeTest> simpleTypeCodec = ProtobufProxy.create(SimpleTypeTest.class);
        Codec<SimpleTypeTest> simpleTypeCodec2 = ProtobufProxy.create(SimpleTypeTest.class);

        SimpleTypeTest stt = new SimpleTypeTest();
        stt.setName("abc");
        stt.setValue(100);
        // 序列化
        byte[] bb = simpleTypeCodec.encode(stt);
        // 反序列化
        SimpleTypeTest newStt = simpleTypeCodec.decode(bb);
        System.out.println(newStt);


        Person person = new Person();
        person.setAge(19);
        person.setSex("boy");
        stt.setPerson(person);

        byte[] cc = simpleTypeCodec.encode(stt);
        // 反序列化
        SimpleTypeTest test2 = simpleTypeCodec.decode(cc);
        System.out.println(test2);
        System.out.println(test2.getPerson());

    }
}
