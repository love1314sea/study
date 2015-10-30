package 设计模式._02_策略模式._01;

//策略的接口
public interface Strategy {
    public int calculate(int a, int b);
}

//具体的策略类，实现接口，重写方法
class AddStrategy implements Strategy {
    @Override
    public int calculate(int a, int b) {
        return  a + b;
    }
}

class SubtractStrategy implements Strategy {
    @Override
    public int calculate(int a, int b) {
        return a - b;
    }
}

class MultiplyStrategy implements Strategy {
    @Override
    public int calculate(int a, int b) {
        return a*b;
    }
}
class DivideStrategy implements Strategy {
    @Override
    public int calculate(int a, int b) {
        return a/b;
    }
}