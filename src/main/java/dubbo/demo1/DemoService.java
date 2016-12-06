package dubbo.demo1;

/**
 * Created by wushang on 16/6/8.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public interface DemoService {

    public String sayHello(String name);

    public List getUsers();
}