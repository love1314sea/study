package 设计模式._02_策略模式._01;

/*
策略模式编写步骤：是面向接口的编程
1 抽象的策略角色：对策略对象定义一个公共的接口
2 具体的策略角色：编写策略类，该类实现了上面的公共接口
3 环境角色：在使用策略对象的类中保存一个对策略类的引用，最终给客户端调用
4          在使用策略对象的类中，实现对策略对象的set和get方法(注入)或者使用构造方法完成赋值。
缺点:导致策略类太多，  解决方法：工厂模式
 */

public class _01_StrategyTest {
    public static void main(String[] args) {
        Strategy strategy = new AddStrategy();
        Environment environment = new Environment(strategy);
        System.out.println(environment.calculate(3, 4));

        environment.setStrategy(new SubtractStrategy());
        System.out.println(environment.calculate(3,4));

    }
}
