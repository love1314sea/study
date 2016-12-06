package 设计模式.装饰模式.demo2;

/**
 * Created by wushang on 16/12/6.
 */
public class Decorator implements Beverage {
	//	private String description = "我只是装饰器，不知道具体的描述";
	private Beverage beverage;

	public Decorator(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription();
	}

	@Override
	public double getPrice() {
		return beverage.getPrice();
	}

}
