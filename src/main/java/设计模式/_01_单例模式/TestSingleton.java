package 设计模式._01_单例模式;

/**
 * Created by wushang on 16/4/14.
 */

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 防止单例在反序列化后成多例
 * readResolve方法测试
 */
public class TestSingleton {

    public static void main(String[] args) throws Exception {
        /**
         * 这样打印出的TestSingleton对象地址一致，
         * 说明依然是单例对象
         * 把readResolve方法注释掉再来一遍看看呢？
         */
        System.out.println(Singleton.getInstance());
        System.out.println(Singleton.getInstance().deepCopy());
    }
}

//单例
class Singleton implements Serializable {
    private static final long serialVersionUID = 1;

    private Singleton() {
    }

    private static class Holder {
        private static Singleton singleton = new Singleton();
    }

    public static Singleton getInstance() {
        return Holder.singleton;
    }

    //重写readResolve()
    private Object readResolve() throws ObjectStreamException {
        return getInstance();
    }

    public Singleton deepCopy() throws Exception {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(Singleton.getInstance());

        InputStream is = new ByteArrayInputStream(os.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(is);
        Singleton test = (Singleton) ois.readObject();
        return test;
    }

}

