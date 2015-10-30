package 新特性._03_枚举;


import java.util.EnumSet;
import java.util.Iterator;

public class _03_EnumSet {

    public static void showEnumSet(EnumSet<Color> enumSet) {
        for(Iterator<Color> iter=enumSet.iterator(); iter.hasNext();)
            System.out.println(iter.next());
    }
    public static void main(String[] args) {
        //定义一个enumSet,使用静态方法of
        EnumSet<Color> enumSet = EnumSet.of(Color.BLACK,Color.WHITE);
        enumSet.add(Color.RED);
        showEnumSet(enumSet);
        System.out.println("--------------");

        //定义一个空的集合，但是要指明类型
        EnumSet<Color> enumSet1 = EnumSet.noneOf(Color.class);
        enumSet1.add(Color.BLACK);
        enumSet1.add(Color.RED);
        showEnumSet(enumSet1);
    }
}
