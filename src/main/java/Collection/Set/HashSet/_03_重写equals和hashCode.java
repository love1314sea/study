package Collection.Set.HashSet;
/*
自己定义的类型放入Set中，必须重写hashCode()和equals()方法，可使用ide自动生成
 */
import java.util.HashSet;

public class _03_重写equals和hashCode {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        set.add(new People_03("zhang"));
        set.add(new People_03("zhang"));//无法添加进去，符合我们的要求
        System.out.println(set);
    }
}
class People_03{
    String name;
    People_03(String name){
        this.name = name;
    }
    public int hashCode() {
        return this.name.hashCode();
    }
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj != null && obj instanceof People_03) {
            People_03 p = (People_03)obj;
            if(name.equals(p.name)){
                return true;
            }
        }
        return false;
    }
}