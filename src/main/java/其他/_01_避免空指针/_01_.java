package 其他._01_避免空指针;

/*
http://blog.csdn.net/lonewolf521125/article/details/41674983
 */

public class _01_ {
    //1: String comparison with literals
    public static void cast1(String str){
      //  if(str.equals("aaa"))//改为：
        if("aaa".equals(str))
        {
           System.out.println("aaa equal");
        }
    }
    //2: Check the arguments of a method
    public static int getLength(String s) {
        if(s == null) //抛出运行时异常，且对这个异常不处理
            throw new IllegalArgumentException("The argument cannot be null");
        return s.length();
    }
    //3. Prefer String.valueOf() method instead of toString()
    public static void case3( ) {
        Integer a = null;
     //   System.out.println(a.toString());//会抛出异常
        System.out.println(String.valueOf(a));//返回null

    }
    public static void main(String[] args) {
        System.out.println(getLength("aa"));

        case3();

        System.out.println("over -----------");

    }
}
