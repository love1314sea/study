package mat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wushang on 16/3/29.
 */
class TObject {
    int[] arr = new int[20000];
}

public class Test1 {
    private List<TObject> list = new ArrayList<TObject>();

    public void test() {

        int i = 0;
        while (true) {
            try {
                Thread.sleep(100);
                //如果不加上循环限制，大概在循环到380多的时候消耗完32M的heap
//                if(i>350){
//                    continue;
//                }

                list.add(new TObject());
                i++;
                System.out.println("There are " + i + " objects created");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] aregs) {
        new Test1().test();
    }
}
//-Xms32M -Xmx32M -XX:+HeapDumpOnOutOfMemoryError  -XX:HeapDumpPath=/Users/wushang/Downloads/heap.bin