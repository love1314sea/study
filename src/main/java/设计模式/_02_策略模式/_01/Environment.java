package 设计模式._02_策略模式._01;


class Environment {
    private Strategy strategy; //接口引用

    public Environment(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    public int calculate(int a, int b) {
        return strategy.calculate(a, b); //调用哪个实现类的方法，取决于是什么类型的strategy
    }
}
