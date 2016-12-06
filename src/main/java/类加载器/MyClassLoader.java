package 类加载器;

/**
 * Created by wushang on 16/11/15.
 */
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {

	private String name; // 类加载器的名字

	private String path = "d://"; // 加载类的路径

	private final String fileType = ".class"; // .class文件扩展名

	public MyClassLoader(String name) {
		super();// 让系统加载器成为该类的加载器的父类加载器

		this.name = name;
	}

	public MyClassLoader(ClassLoader parent, String name) {
		super(parent); // 显示指定该类加载器的父加载器
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * 读取class文件作为二进制流放入到byte数组中去
	 * @param name
	 * @return
	 */
	private byte[] loadClassData(String name) {
		InputStream in = null;
		byte[] data = null;
		ByteArrayOutputStream baos = null;

		try {
			name = name.replace(".", "\\");
			in = new BufferedInputStream(new FileInputStream(new File(path
					                                                          + name + fileType)));
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
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					baos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return data;
	}

	/**
	 * JVM调用的加载器的方法
	 */

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] data = this.loadClassData(name);
		return this.defineClass(name, data, 0, data.length);
	}

	public static void main(String[] args) throws Exception {
		MyClassLoader loader1 = new MyClassLoader("loader1");
		loader1.setPath("d://");
		test(loader1);
	}

	public static void test(ClassLoader loader) throws Exception{
		Class<?> clazz = loader.loadClass("com.bird.classLoad.Simple");
		Object object = clazz.newInstance();
	}

}