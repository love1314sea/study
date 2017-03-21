package 反射.类加载器;

/**
 * Created by wushang on 16/11/16.
 */

//参考: http://blog.csdn.net/zhu_xun/article/details/24959231
public class TestGetResource {

	public static void main(String[] args) throws Exception {
		/**
		 * TestGetResource.class.getResource("aa.txt")从当前路径下（TestGetResource类所在路径）查找资源（aa.txt）
		 * TestGetResource.class.getClassLoader().getResource("foo.dat")从classpath路径下寻找资源（foo.dat）
		 * */
		System.out.println(TestGetResource.class.getResource("/goo.txt"));//从classpath目录
		System.out.println(TestGetResource.class.getResource("goo.txt"));//从当前类目录
		System.out.println(TestGetResource.class.getResource("../resource/goo.txt"));
		System.out.println(TestGetResource.class.getClassLoader().getResource("resource/goo.txt"));
		System.out.println(TestGetResource.class.getClassLoader().getResource("foo.dat"));
	}
}