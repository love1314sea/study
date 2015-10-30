package Collection.Set.HashSet;

import java.util.HashSet;

/*
Set : 1无序 2不包含重复元素
1 HashSet的底层是HashMap实现的。
 */
public class _01_HashSet {
    public static void main(String[] args ) {
        HashSet set = new HashSet();
        set.add("a");
        set.add("b");
        set.add("c");
        System.out.println(set.add("a"));//添加失败，返回false

        System.out.println(set);
    }
}
