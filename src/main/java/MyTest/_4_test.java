package MyTest;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by wushang on 15/12/4.
 */
public class _4_test {

    public static void main(String[] args) {
        Random random = new Random();

        ArrayList<Integer> list = new ArrayList<>(1000);
        for(long i=0; i<1000; ++i) {
            int tmp = random.nextInt(10000);
//            System.out.println(tmp);
            list.add(tmp);
        }


        for(int i=0; i<1000; ++i) {

        }

    }
}
