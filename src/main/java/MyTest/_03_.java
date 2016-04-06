package MyTest;

/**
 * Created by wushang on 15/12/2.
 */
public class _03_ {

    public static void main(String[] args) {
        int newCap = 100;
        int oldCap = 40;
        int MAXIMUM_CAPACITY = 1000;
        int DEFAULT_INITIAL_CAPACITY = 20;
        if((newCap = oldCap << 1) < MAXIMUM_CAPACITY && oldCap >= DEFAULT_INITIAL_CAPACITY) {
            System.out.println("newCap = " + newCap);
        }
    }
}
