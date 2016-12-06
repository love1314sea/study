package 枚举.demo1;

/**
 * Created by wushang on 15/10/12.
 */
// 参考http://www.yiibai.com/javalang/enum_valueof.html 和flume代码

//https://my.oschina.net/yotoo/blog/266466
enum Mobile {
    Samsang(500),
    Nokia(200);

    int price;
    Mobile(int price) {
        this.price = price;
    }
}
enum Color {
    RED,YELLOW,GREEN;
}

enum Classes {
    CLASS1(MyClass1.class),
    CLASS2(MyClass2.class);

    Class <?> builderClass;
    private Classes(Class<?> builderClass) {
        this.builderClass = builderClass;
    }
    public Class<?> getBuilderClass() {
        return builderClass;
    }
}
public class _01_test {
    public static void main(String[] args) {
        for(Color color: Color.values()) {
            System.out.println(color.ordinal());
        }

        for(Mobile mobile: Mobile.values()) {
            System.out.println(mobile.ordinal());
        }

        Classes type = Classes.valueOf("CLASS1");
        System.out.println(type);
    }
}
