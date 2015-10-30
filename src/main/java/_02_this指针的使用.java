/*
一般使用this指针：
1 构造函数的参数和成员变量同名
2 返回自身
 */
public class _02_this指针的使用 {

    public int i;
    _02_this指针的使用(int i) {
        this.i = i;
    }
    public _02_this指针的使用 incream() {
        i++;
        return this;
    }

    public static void main(String[] args) {
        _02_this指针的使用 test = new _02_this指针的使用(0);
        test.incream().incream().incream();//连用
        System.out.println(test.i);
    }
}
