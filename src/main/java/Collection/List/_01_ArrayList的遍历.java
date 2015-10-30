package Collection.List;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _01_ArrayList的遍历 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
     //   ArrayList<String> list2 = new ArrayList(); //后面的<>可省略
        list.add("a");
        list.add("b");
        list.add(0,"c");
        //遍历方式1：
        for(int i=0; i<list.size(); ++i) {
            System.out.println(list.get(i));
        }
        //2:使用迭代器遍历，指明迭代器中泛型的具体类型
        for(Iterator<String> iter=list.iterator();iter.hasNext();) {
            System.out.println(iter.next());
        }
        //3:使用增强for循环遍历，但丢掉了index信息
        for(String s : list)
            System.out.println(s);
    }
}
