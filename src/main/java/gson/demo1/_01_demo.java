package gson.demo1;

import com.google.gson.Gson;

/**
 * 字符串json和对象互相转换
 */

public class _01_demo  {
    public static void main(String[] args) {
        final Gson gson = new Gson();

        final Person jack = new Person("Jackie", 15 );
        final String json = gson.toJson(jack);
        System.out.println(json);//转换为字符串，{"name":"Jackie","age":15}

        final Person jack2 = gson.fromJson(json, Person.class);//json串转换成person对象
//        System.out.println(jack.equals(jack2));
    }
 }
