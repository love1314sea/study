package gson.demo1;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wushang on 15/7/9.
 * http://blog.csdn.net/jackie_xiaonan/article/details/14498187
 */
public class _04_处理容器List {
    public static void main(String[] args) {
        Person person1 = new Person("zhang",13);
        Person person2 = new Person("li", 15);
        Person person3 = new Person("zhao",20);

        Gson gson = new Gson();
        String json = gson.toJson(Arrays.asList(person1, person2, person3));
        System.out.println(json);

        final Type personListType = new TypeToken<List<Person>>(){}.getType();//容器有泛型，运行期间类型擦除，都是Object

        final List<Person> list = gson.fromJson(json, personListType);
        for(final Person person : list) {
            System.out.println(person);
        }

    }
}
