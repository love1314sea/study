package gson.demo1;

import com.google.gson.Gson;

/**
 * Created by wushang on 15/7/9.
 */
public class _03_对象是成员变量 {
    public static void main(String[] args) {
        Family family1 = new Family();
        family1.setEmail("1111@qq.com");
        family1.setPhone("123");
        Person jack = new Person("Jack boy", 15);
        family1.setPerson(jack);

        Family family2 = new Family();
        family2.setEmail("2222@qq.coom");
        family2.setPhone("234");
        family2.setPerson(new Person());

        Family family3 = new Family();
        family3.setEmail("333@qq.com");
        family3.setPhone("345");

        Gson gson = new Gson();
        String json = gson.toJson(new Family[]{family1, family2, family3});
        System.out.println(json);

        Family[] families = gson.fromJson(json, Family[].class);
        for(Family family:families) {
            System.out.println(family);
        }
    }
}
