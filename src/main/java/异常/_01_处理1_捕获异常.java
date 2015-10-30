package 异常;
/*
1 java中异常主要分两类
 a 运行时异常（RuntimeException、 unchecked exception) : 所有的运行时异常都直接或间接继承自RuntimeException
   可以处理也可以不处理，推荐不处理。而是自己由程序确保不抛出这种异常。
 b 非运行时异常:对于此类(checked exception),必须处理。两种方法一是捕获二是抛出
2 异常发生，如果不catch，会被main函数接受，抛给jvm，直接终止程序；
  我们需要catch异常，对程序进行挽救工作，然后沿着catch后执行。
 */
public class _01_处理1_捕获异常 {
    public static void main(String[] args) {
        int c = 0;
        try {
            int a = 4;
            int b = 0;
            c = a / b; //异常发生
            System.out.println("hello world --- 1"); //不会执行
        }catch(ArithmeticException e) {
            System.out.println("catch exception ArithmeticException");//捕获相应异常，执行
            e.printStackTrace();
        }finally {
            System.out.println("hello world --- 2"); //执行
        }

        System.out.println("hello world ----- 3");//执行
        System.out.println(c);

    }
}
