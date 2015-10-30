package Collection.Set.HashSet;
/*
当使用HashSet时，hashCode()方法就会得到调用,先判断是否有相同的hashCode值存在；
如果不存在，加进去；如果存在,再进行equals方法的比较，如果equals方法返回true，表示已经存在，不添加进去；
如果返回false，则添加进去。
 */

import java.util.HashSet;

public class _02_HashSet的内部机制 {
    public static void main(String[] args) {
        HashSet set1 = new HashSet();
        set1.add(new People("zhang"));
        set1.add(new People("zhang")); //能添加进去，先比较hashcode(),People类继承Object类，使用Object类中的hashcode方法
        System.out.println(set1);  // 不同的对象有不同的hashcode值，因此能添加

        HashSet set2 = new HashSet();
        People p = new People("zhang");
        set2.add(p);
        set2.add(p);//不能添加  object类中hashcode方法，同一对象有相同的hashcode值，且自己和自己equal是相等的
        System.out.println(set2);

        HashSet set3 = new HashSet();
        String s1 = new String("a");
        String s2 = new String("a");
        set3.add(s1);
        set3.add(s2);//不能添加 String类重写了hashcode()和equal()方法。
        System.out.println("hashcode:"+ (s1.hashCode()==s2.hashCode()));//true
        System.out.println(set3);//String类中的hashCode()方法同字符串内容相关，最后结果不能添加
    }
}
class People{
    String name;
    public People(String name){
        this.name = name;
    }
}
