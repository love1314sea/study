package IO._04_序列化;

import java.io.*;
/*
对象序列化就是把Object对象转换成byte序列，反之，把byte序列转换成对象就是反序列化
使用： ObjectOutputStream  ObjectInputStream
必须实现Serializable这个标识
 */
/*
1 当一个对象被序列化时，只能序列化非静态变量，不能序列化static静态变量（静态变量是属于类的）
2 当一个对象的成员变量是一个对象时，那么这个对象的成员变量也会被序列化
3 当一个可序列化的对象包含对某个不可序列化的对象的引用时，那么整个序列化操作将失败。(即这个对象未实现Serializable接口）
  并且会抛出一个NotSerializableException.
  可以将这个引用标记为transient,那么对象仍然可以序列化。
 */
public class _01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Person p1 = new Person(15, "zhang", 65.2);
        Person p2 = new Person(25, "wang", 69.2);

        FileOutputStream fos = new FileOutputStream("D:\\test\\p.txt");
        //序列化使用ObjectOutputStream，它是过滤流
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(p1);
        oos.writeObject(p2);
        oos.close();

        FileInputStream fin = new FileInputStream("D:\\test\\p.txt");
        //反序列化使用ObjectInputStream类，也是过滤流
        ObjectInputStream ois = new ObjectInputStream(fin);
        Person a1 = (Person)ois.readObject();//readObject返回值是Object，必须要转换类型
        System.out.println(a1.age);
        System.out.println(a1.height);//height未被序列化，得到0.0，但不抛出异常
        Person a2 = (Person)ois.readObject();
        System.out.println(a2.age);
     //   Person a3 = (Person)ois.readObject();//如果没有了，还读，会抛出异常
      //  System.out.println(a3.age);
        ois.close();
    }

}
class Person implements Serializable {//必须implements这个标识
    int age;
    String name;
    transient double height;//不会被序列化
    public Person(int age,String name, double height) {
        this.age = age;
        this.name = name;
        this.height = height;
    }

}
