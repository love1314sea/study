package 反射.类加载器;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Properties;

/**
 * Created by wushang on 16/11/16.
 */
// 参考: http://blog.csdn.net/a454832841/article/details/38661635
public class _01_UrlClassLoaderTest {

	public static void main(String[] args) throws Exception{

		Properties properties = new Properties();

		//必须声明协议; 最后必须加上/
		URL[] urls = new URL[] {new URL("file:/Users/wushang/IdeaProjects/toyprogram/study/src/main/java/反射/类加载器/")};
		URLClassLoader urlClassLoader = new URLClassLoader(urls);// 默认父加载器是系统加载器
		InputStream inputStream = urlClassLoader.getResourceAsStream("test.properties");
		properties.load(inputStream);

		System.out.println(properties.get("hello"));


		File file = new File("/Users/wushang/IdeaProjects/toyprogram/study/src/main/java/反射.类加载器/_01_UrlClassLoaderTest.java");
		file.toURI().toURL();
	}
}
