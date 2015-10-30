package 反射._01_Class类;


public class _01_通过子类获得父类的class对象 {
    public static void main(String[] args) {
        Class<?> classType = Child.class;
        System.out.println(classType);
        classType = classType.getSuperclass();
        System.out.println(classType);
        classType = classType.getSuperclass(); //获得Object类的Class对象
        System.out.println(classType);
        classType = classType.getSuperclass();//没有父类，返回null
        System.out.println(classType);
    }
}

class Parent {

}
class Child extends Parent {

}