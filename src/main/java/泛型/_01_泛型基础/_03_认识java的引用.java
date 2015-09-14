package 泛型._01_泛型基础;
/*
java中的引用和c中的指针是不同的
1 java中只有值传递，没有引用传递
2 java引用应该封装了类型信息+地址；如String  String[]
  a 这样能知道是不是数组；c只知道是地址，不知道具体类型
  b 所以java类型转换时要注意，要与里面保存的类型一致。
 */

public class _03_认识java的引用 {
    public static void main(String[] args) {
        Generic3<String> g1 = new Generic3<String>();
        String[] arr = {"hello", "my", "girl"};
        g1.setFoolArray(arr);

        String[] arr2 = null;
        arr2 = g1.getFoolArray(); //java中的引用和c中的指针是不同的,此处java知道arr2是String[]类型，但C只知道是指针
        for(String str: arr2) {
            System.out.println(str);
        }
    }
}

class Generic3<T> {
    private T[] foolArray;//成员变量是一个数组

    public T[] getFoolArray() {
        return foolArray;
    }

    public void setFoolArray(T[] foolArray) {
        this.foolArray = foolArray;
    }
}
