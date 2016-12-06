package 设计模式.装饰模式.demo1;

/**
 * Created by wushang on 16/12/6.
 */
//参考: https://jiangyixuan.github.io/2016/09/17/java%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F-%E8%A3%85%E9%A5%B0%E6%A8%A1%E5%BC%8F/
public class Client {
	public static void main(String[] args) {
//        //节点流 FileOutputStream
//        Component component = new ConcreateComponent();
        //过滤流 BuffererOutputStream DataArrayOutputStream
//        Component component1 = new ConcreteDecorator1(component);
//        Component component2 = new ConcreteDecorator2(component1);
//        component2.dosomething();
		Component component = new ConcreteDecorator2(new ConcreteDecorator1(new ConcreateComponent()));
		component.dosomething();
	}
}
