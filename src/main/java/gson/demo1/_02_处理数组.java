package gson.demo1;

import com.google.gson.Gson;

/**
 * Created by wushang on 15/7/9.
 */
public class _02_处理数组 {
    public static void main(String[] args) {
        final Gson gson = new Gson();
        Person jack1 = new Person("Jackie", 30);
        Person jack2 = new Person("Jackie boy", 15);

        String json = gson.toJson(new Person[]{jack1, jack2});  //对象数组转换成json字符串
        System.out.println(json); //[{"name":"Jackie","age":30},{"name":"Jackie boy","age":15}]

        final Person[] persons = gson.fromJson(json, Person[].class);
        for (final Person person : persons) {
            System.out.println(person);
        }

    }
}
