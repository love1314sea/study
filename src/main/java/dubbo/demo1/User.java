package dubbo.demo1;

import java.io.Serializable;

/**
 * Created by wushang on 16/6/12.
 */
public class User implements Serializable{
    String name;
    int age;
    String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
