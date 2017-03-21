package 反射.类加载器;

import java.io.*;

/**
 * Created by wushang on 16/11/15.
 */
/*
1 构造函数,指定父加载器
2 重写了  findClass,读取二进制文件;并调用defineClass
 */
public class MyClassLoader2 extends ClassLoader {

	private String path;

	public MyClassLoader2() {
		super();// 让系统加载器成为该类的加载器的父类加载器
	}

	public MyClassLoader2(ClassLoader classLoader) {
		super(classLoader);
	}
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		System.out.println(name);
		InputStream in = null;
		byte[] data = null;
		ByteArrayOutputStream baos = null;
		try {
			in = new BufferedInputStream(new FileInputStream(new File(path + "/" + name + ".class")));
			baos = new ByteArrayOutputStream();
			int ch = 0;
			while (-1 != (ch = in.read())) {
				baos.write(ch);
			}
			data = baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				baos.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return this.defineClass(name, data, 0, data.length);
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public static void main(String[] args) throws Exception {
		MyClassLoader2 classLoader2 = new MyClassLoader2();
		classLoader2.setPath("/Users/wushang/IdeaProjects/toyprogram/study/target/classes/");
		Class<Person> classType = (Class<Person>)classLoader2.loadClass("反射.类加载器.Person");
		Object object = classType.newInstance();
		System.out.println(object);
	}
}
