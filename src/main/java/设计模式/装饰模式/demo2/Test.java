package 设计模式.装饰模式.demo2;

/**
 * Created by wushang on 16/12/6.
 */
//参考:  http://blog.csdn.net/zhshulin/article/details/38665187
public class Test {

	public static void main(String[] args) {
		Beverage beverage = new CoffeeBean1();  //选择了第一种咖啡豆磨制的咖啡
		beverage = new Mocha(beverage);     //为咖啡加了摩卡
		beverage = new Milk(beverage); //再上面的基础上,再加上奶
		System.out.println(beverage.getDescription()+"\n加了摩卡和牛奶的咖啡价格："+beverage.getPrice());

	}
}