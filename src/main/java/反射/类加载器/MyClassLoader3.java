package 反射.类加载器;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * Created by wushang on 15/11/1.
 */
/*
打破java的 父亲委托机制：自己定义的类，优先使用自己的加载器
这是就需要也重写 loadClass方法
 */
public class MyClassLoader3 extends ClassLoader {


    //定义文件所在目录
    private static final String DEAFAULTDIR = "/Users/wushang/IdeaProjects/toyprogram/study/target/classes/";

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {

        byte[] b = null;
        try {
            File file = new File(GetClassName(name));
            if (!file.exists()) {
                return null;
            }
            int n = 0;
            BufferedInputStream br = new BufferedInputStream(new FileInputStream(file));
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            while ((n = br.read()) != -1) {
                bos.write(n);
            }
            br.close();
            b = bos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defineClass(name, b, 0, b.length);
    }

    @Override
    protected synchronized Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {

        if (name.startsWith("java.")) { //优化
            try {
                return super.loadClass(name, false);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        Class<?> clazz = null;
        try {
            clazz = findClass(name);  //优先使用自己定义的加载器
        } catch (Exception e) {
//            e.printStackTrace();
            System.err.println("error----");
        }

        if (clazz == null && getParent() != null) {
            clazz = getParent().loadClass(name);//如果自己的找不到， 则使用 父类的加载器
        }
        return clazz;

    }

    public static String GetClassName(String name) {
        return DEAFAULTDIR + name.replace('.', '/') + ".class";
    }

    public static void main(String[] args) throws Exception {
        MyClassLoader3 loader3 = new MyClassLoader3();
        Class<?> clazz = loader3.loadClass("java.lang.String");
        System.out.println(clazz.getName());

        System.out.println(clazz.getClassLoader());//如果为null，则说明是 boost 加载器

        System.out.println("1--------------------");

        Class<?> clazz2 = loader3.loadClass("反射.类加载器.ClassLoaderTree");

        System.out.println(clazz2.getName());
        System.out.println(clazz2.getClassLoader());

        System.out.println("2--------------------");

        //会报错: 因为 父亲加载器看不到子类加载器加载 的类， 当前执行MyClassLoader3中的main方法，
        // 是 系统加载器加载的， 但是clazz2 是自己定义的加载器加载的， 不可见。
        ClassLoaderTree loaderTree = (ClassLoaderTree)clazz2.newInstance();


    }
}