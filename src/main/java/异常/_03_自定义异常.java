package 异常;

class MyException extends Exception {
    public MyException(){
        super();
    }
    public MyException(String message) {
        super(message);
    }
}
public class _03_自定义异常 {
    public static void method(String str) throws MyException{
        if(str == null){
            throw new MyException("指针为空");
        }
        else {
            System.out.println("----");
        }
    }
    public static void main(String[] args) throws Exception{

        try {
            method(null);
        }catch (Exception e) {
            e.printStackTrace();
        }
     //   method(null);

        System.out.println("执行结束");
    }
}
