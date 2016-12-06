package 设计模式.装饰模式.demo2;

/**
 * Created by wushang on 16/12/6.
 */
public class Mocha extends Decorator {
	private String description = "加了摩卡！";
	public Mocha(Beverage beverage){
		super(beverage);
	}
	public String getDescription(){
		return super.getDescription()+"\n"+description;
	}
	public double getPrice(){
		return super.getPrice()+49;  //30表示摩卡的价格
	}
}
