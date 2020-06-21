package fastjson.demo1;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by wushang on 16/3/4.
 */
public class boostrap {
    public static void main(String[] args) {
        Group group = new Group();
        group.setId(0L);
        group.setName("admin");

        User guestUser = new User();
        guestUser.setId(2L);
        guestUser.setName("guest");

        User rootUser = new User();
        rootUser.setId(3L);
        rootUser.setName("root");

        group.getUsers().add(guestUser);
        group.getUsers().add(rootUser);
        //1 对象转换为字符串
        String json = JSON.toJSONString(group);
        System.out.println(json);
        //2 json字符串转换为已知的对象
        Group group1 = JSON.parseObject(json, Group.class);
        //3 json字符串转为为JsonObject
        JSONObject jsonObject1 = JSON.parseObject(json);
        //3-1: 如果没有，会为null
        System.out.println(jsonObject1.getString("hello"));
        System.out.println(jsonObject1.getString("name"));
        //3-2：如果为数组，也会转换为字符串
        System.out.println(jsonObject1.getString("users"));

        JSONArray jsonArray1 = JSON.parseArray(jsonObject1.getString("users"));
        System.out.println(jsonArray1.getJSONObject(1).getString("id"));
        System.out.println("over----");

    }
}
