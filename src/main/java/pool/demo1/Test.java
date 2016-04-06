package pool.demo1;


import org.apache.commons.pool.ObjectPool;
import org.apache.commons.pool.PoolableObjectFactory;
import org.apache.commons.pool.impl.StackObjectPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// http://blog.csdn.net/kongxx/article/details/6607083
//  http://my.oschina.net/ydsakyclguozi/blog/397199
//http://www.cnblogs.com/shipengzhi/archive/2011/06/02/2068628.html
public class Test {
    private static Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) throws Exception {
        PoolableObjectFactory factory = new MyConnectionPoolableObjectFactory();
        ObjectPool pool = new StackObjectPool(factory);
        try {
            System.out.println("1================================================");
            for (int i = 0; i < 10; i++) {
                MyConnection myConn = (MyConnection) pool.borrowObject();
                try {
                    myConn.print();
                } catch (Exception ex) {
                    pool.invalidateObject(myConn);
                } finally {
                    pool.returnObject(myConn);
                }
            }

            System.out.println("2================================================");
            for (int i = 0; i < 10; i++) {
                MyConnection myConn1 = (MyConnection) pool.borrowObject();
                MyConnection myConn2 = (MyConnection) pool.borrowObject();
                myConn1.print();
                myConn2.print();
                pool.returnObject(myConn1);
                pool.returnObject(myConn2);
            }
        } finally {
            try {
                pool.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
