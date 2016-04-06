package fastjson.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wushang on 16/3/4.
 */
public class Group {
    private Long id;
    private String name;
    private List<User> users = new ArrayList<User>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<User> getUsers() { return users; }
    public void setUsers(List<User> users) { this.users = users; }
}
