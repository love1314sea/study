package 异常;

public class _02_处理2_抛出异常 {
    public void method() throws Exception{
        System.out.println("hello 1");

        throw new Exception();

       // System.out.println("hello 2"); //不可能运行的代码
    }
    public static void main(String[] args) {
        _02_处理2_抛出异常 e = new _02_处理2_抛出异常();
        try {
            e.method();
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("catch--------");
        }finally {
            System.out.println("finally -----");
        }
    }
}
