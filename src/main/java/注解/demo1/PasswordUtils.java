package 注解.demo1;

import java.lang.reflect.Method;

/**
 * Created by wushang on 15/9/28.
 */
public class PasswordUtils {

    @UseCase(id=47, description = "hello")
    public boolean validatePassword(String password) {
        return password.matches("\\w*\\d\\w*");
    }

    @UseCase(id = 48)
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }

    public static void trackUseCases( Class<?> cl) {
        for(Method m : cl.getDeclaredMethods()) { //通过反射获得PasswordUtils 类的方法
            UseCase uc = m.getAnnotation(UseCase.class); //获得方法上的注解
            if(uc != null) {
                System.out.println("found use case:" + uc.id() + " " + uc.description());
            }
        }
    }
    public static void main(String[]  args ) {
        trackUseCases(PasswordUtils.class);
    }

}
