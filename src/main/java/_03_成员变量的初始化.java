
public class _03_成员变量的初始化 {


    public int i = 0;
    public int j = g(i);//可以调用函数来初始化
    public int g(int gg) {
        return gg+10;
    }

    public static void main(String[] args) {
        _03_成员变量的初始化 test = new _03_成员变量的初始化();
        System.out.println(test.j);
    }
}
