package fastjson.demo1;


import com.alibaba.fastjson.JSON;

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
        String json = JSON.toJSONString(group);
        System.out.println(json);


        Group group1 = JSON.parseObject(json, Group.class);
    }
}
