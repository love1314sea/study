package protobuf.demo2;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * Created by wushang on 16/4/1.
 */
public class Person {
    @Protobuf(fieldType = FieldType.STRING, order = 1, required = true)
    private String sex;

    @Protobuf(fieldType = FieldType.INT32, order = 2, required = true)
    private int age;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "[sex=" + sex + ", age=" + age + "]";
    }
}
