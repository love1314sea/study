package 设计模式._02_策略模式._03;


import java.util.List;

public class Environment {
    private SortInterface sortInterface;

    public Environment(SortInterface sortInterface) {
        this.sortInterface = sortInterface;
    }

    public void setSortInterface(SortInterface sortInterface) {
        this.sortInterface = sortInterface;
    }

    //对于这里自己有一个误区，总是潜意识以为函数参数只使用成员变量，我们可以从任意地方传入参数
    public void sort(List<Student> list) {
        sortInterface.sort(list);
    }
}
