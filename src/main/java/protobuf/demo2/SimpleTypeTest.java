package protobuf.demo2;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;


/**
 * A simple jprotobuf pojo class just for demo.
 *
 * @author xiemalin
 * @since 1.0.0
 */
public class SimpleTypeTest {

    @Protobuf(fieldType = FieldType.STRING, order = 1, required = true)
    private String name;

    @Protobuf(fieldType = FieldType.INT32, order = 2, required = false)
    private int value;
    @Protobuf(fieldType = FieldType.OBJECT, order = 3, required = false)
    private Person person;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "[name=" + name + ", value=" + value + ", person=" + person + "]";
    }
}