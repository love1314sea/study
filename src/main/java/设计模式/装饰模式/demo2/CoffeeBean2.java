package 设计模式.装饰模式.demo2;

/**
 * Created by wushang on 16/12/6.
 */
public class CoffeeBean2 implements Beverage {
	private String description = "选了第二种咖啡豆";

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public double getPrice() {
		return 100;
	}
}
