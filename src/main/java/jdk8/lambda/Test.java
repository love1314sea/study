package jdk8.lambda;

/**
 * @author wushang@tingyun.com
 * @date 2018/4/27
 */
public class Test {

    public void strHandler(String string, MyFunction function) {
        function.getValue(string);
    }

    public void exe() {
        strHandler("aaa", (str) -> str + " bbb");
    }

    public static void main(String[] args) {

    }
}
