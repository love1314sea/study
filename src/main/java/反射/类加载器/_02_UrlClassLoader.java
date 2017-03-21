package 反射.类加载器;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Properties;

/**
 * Created by wushang on 17/1/17.
 */
public class _02_UrlClassLoader {
	public static void main(String[] args) throws Exception{

        //
		URL[] urls = new URL[] {new URL("file:/Users/wushang/IdeaProjects/es-util/target/es-util-0.0.1-SNAPSHOT.jar")};
//		URL[] urls = new URL[] {new URL("file:/Users/wushang/IdeaProjects/es-util/target/")};

		URLClassLoader urlClassLoader = new URLClassLoader(urls);// 默认父加载器是系统加载器
//		InputStream inputStream = urlClassLoader.getResourceAsStream("a");
		Class<?> type = urlClassLoader.loadClass("com.tingyun.dc.es.entity.IndexItem"); //不包含.class后缀,
		System.out.println(type);

//		int c = 0;
//		while ( (c = inputStream.read()) != -1) {
//			System.out.print(c);
//		}
	}
}
