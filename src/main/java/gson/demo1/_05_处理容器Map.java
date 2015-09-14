package gson.demo1;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.*;

/**
 * Created by wushang on 15/7/10.
 */

public class _05_处理容器Map {
    public static void main(String[] args) {
        final Gson gson = new Gson();
        Person05 jack1 = new Person05();
        jack1.setAge(30);
        jack1.setName("li");
        jack1.putValue("email", "email");
        jack1.putValue("phoneno", "phoneno");

        Person05 jack2 = new Person05();
        jack2.setAge(29);
        jack2.setName("zhang");
        jack2.putValue("email2", "email2");
        jack2.putValue("phone2", "phone2");

        String json = gson.toJson(Arrays.asList(jack1, jack2));
        System.out.println(json);

        Type personListType = new TypeToken<List<Person05>>(){}.getType();
//        List<Person05> list = gson.fromJson(json, personListType);
        List<Person05> list = gson.fromJson(json, personListType);
        for(final Person05 person05 : list) {
            System.out.println(person05);
        }

        System.out.println("-----------------");

        String json2 = gson.toJson(new Person05[]{jack1,jack2});
        System.out.println(json2);
        Person05[] person05s = gson.fromJson(json2,Person05[].class);
        for(Person05 person05: person05s) {
            System.out.println(person05);
        }
    }
}

class Person05{
    private String name;
    private int age;
    private Map<String,Object> contact;


    public Person05() {
        contact = new HashMap<>();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void putValue(String key, final Object object) {
        contact.put(key,object);
    }

    @Override
    public String toString() {
        return name+":"+age;
    }
}
