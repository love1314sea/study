package 类._01_Object类;


public class _04_toString方法 {
    public static void main(String[] args) {
        //所有的类都继承自Object类，也就有父类的所有方法，如果自己不重写，会调用父类的方法
        System.out.println(new Student04());//类._01_Object类.Student04@6909037d

        String str = "hello";
        System.out.println(str);//String 类重写了toString方法
    }
}
class Student04 {

}