package 设计模式._02_策略模式._02;


import java.util.Comparator;
import java.util.Objects;

class Environment<T extends Student> implements Comparator {
    private Strategy strategy;

    Environment(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    public int compare(Object s1, Object s2){
        return strategy.compare((T)s1,(T)s2);
    }
}
/*        // Comparator<Student> 给泛型赋类型
class Environment<T extends Student> implements Comparator<Student> {
    private Strategy strategy;

    Environment(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    public int compare(Student s1, Student s2){ //会成为实际类型
        return strategy.compare(s1,s2);
    }
}
*/