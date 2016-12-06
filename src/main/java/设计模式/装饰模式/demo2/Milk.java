package 设计模式.装饰模式.demo2;

/**
 * Created by wushang on 16/12/6.
 */
public class Milk extends Decorator {
	private String description = "加了牛奶！";

	public Milk(Beverage beverage) {
		super(beverage);
	}

	public String getDescription() {//功能的累计:
		return super.getDescription() + "\n" + description;
	}

	public double getPrice() {
		return super.getPrice() + 20;  //20表示牛奶的价格
	}
}