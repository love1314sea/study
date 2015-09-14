package IO.序列化;

/*
序列化就是把Object对象转换
        */
import java.io.*;


public class _02_自定义序列化方式  {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Person2 p1 = new Person2(15, "zhang", 65.2);
        Person2 p2 = new Person2(25, "wang", 69.2);

        FileOutputStream fos = new FileOutputStream("D:\\test\\p.txt");
        //序列化使用ObjectOutputStream，它是过滤流
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(p1);
        oos.writeObject(p2);
        oos.close();

        FileInputStream fin = new FileInputStream("D:\\test\\p.txt");
        //反序列化使用ObjectInputStream类，也是过滤流
        ObjectInputStream ois = new ObjectInputStream(fin);
        Person2 a1 = (Person2)ois.readObject();//readObject返回值是Object，必须要转换类型
        System.out.println(a1.age);
        System.out.println(a1.height);//height未被序列化，得到0.0，但不抛出异常
        Person2 a2 = (Person2)ois.readObject();
        System.out.println(a2.age);
        //   Person2 a3 = (Person2)ois.readObject();//如果没有了，还读，会抛出异常
        //  System.out.println(a3.age);
        ois.close();
    }


}
class Person2 implements Serializable {//必须implements这个标识
    int age;
    String name;
    transient double height;//不会被序列化
    public Person2(int age,String name, double height) {
        this.age = age;
        this.name = name;
        this.height = height;
    }
    //如果类中有着两个方法，会调用这两个方法进行序列化和反序列化,完全由自己控制
    private void writeObject(java.io.ObjectOutputStream out)
            throws IOException {
        System.out.println("write object");
        out.writeInt(age);
        out.writeUTF(name);
        out.writeDouble(height);//此时 修饰height的transient 不起作用了
    }
    private void readObject(java.io.ObjectInputStream in)
            throws IOException, ClassNotFoundException{
        System.out.println("read object");
        age = in.readInt();
        name = in.readUTF();
        height = in.readDouble();
    }
}
