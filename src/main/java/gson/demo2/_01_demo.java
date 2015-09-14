package gson.demo2;

/**
 * Created by wushang on 15/7/10.
 * 自定义解析过程，解析时可以忽略某些字段
 * http://blog.csdn.net/jackie_xiaonan/article/details/15026901
 */

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class _01_demo {
    public static void main(final String[] args) {
        final Gson gson = new Gson();
        final Person jack1 = new Person();
        jack1.setAge(30);
        jack1.setName("Jackie");

        jack1.putValue("email", "email");
        jack1.putValue("phoneno", "phoneno");

        final Person jack2 = new Person();
        jack2.setAge(1);
        jack2.setName("Jackie Boy");
        jack2.putValue("email", "email");
        jack2.putValue("phoneno", "phoneno");

        final String json = gson.toJson(Arrays.asList(jack1, jack2));
        System.out.println(json);

        List<Person> jacks = null;
        // 自定义解码处理过程，跳过对字段age的处理
        JsonReader reader = null;
        InputStream in = null;
        try {
            in = new ByteArrayInputStream(json.getBytes("UTF-8"));
            reader = new JsonReader(new InputStreamReader(in, "UTF-8"));

            jacks = decode(reader);

            for (final Person person : jacks) {
                System.out.println("jack = " + person);
            }
        } catch (final Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 如下方法是重点，解析操作的处理过程
    private static List<Person> decode(JsonReader reader) throws IOException {
        List<Person> jacks;
        jacks = new ArrayList<Person>();
        reader.beginArray();// 通知gson框架，这里开始解析的是数组类型
        while (reader.hasNext()) {
            final Person p = new Person();
            jacks.add(p);
            reader.beginObject();// 通知gson框架，这里开始解析的是对象
            while (reader.hasNext()) {
                final String name = reader.nextName();// 提到名、值对中的名
                if (name.equals("name")) {
                    final String value = reader.nextString();
                    p.setName(value);
                } else if (name.equals("contact")) {
                    reader.beginObject();// 通知gson框架，这里开始解析的是对象
                    while (reader.hasNext()) {
                        final String key = reader.nextName();
                        final String value = reader.nextString();
                        p.putValue(key, value);
                    }
                    reader.endObject();// 通知gson框架，对对象的解析完成
                } else {
                    reader.skipValue();// 跳过不必要的字段，根据之前的设定，这里只能是age
                }
            }
            reader.endObject();// 通知gson框架，对对象的解析完成</span>

        }
        reader.endArray();// 通知gson框架，数组对象的解析完成</span>
        return jacks;
    }
}

//@Data
class Person {
    private String name;
    private int age;
    private Map<String, Object> contact;

    public Person() {
        contact = new HashMap<String, Object>();
    }

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

    public void putValue(final String key, final Object value) {
        contact.put(key, value);
    }

    @Override
    public String toString() {
        return name+":" +age;
    }
}

