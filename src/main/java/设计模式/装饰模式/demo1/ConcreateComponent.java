package 设计模式.装饰模式.demo1;

/**
 * Created by wushang on 16/12/6.
 */
public class ConcreateComponent implements Component{
	@Override
	public void dosomething() {
		System.out.println("功能A....");
	}
}