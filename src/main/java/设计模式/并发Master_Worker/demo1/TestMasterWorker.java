package 设计模式.并发Master_Worker.demo1;

/**
 * Created by wushang on 15/7/19.
 */
/*
应用Master-Worker框架，实现计算立方和的应用，并计算1~100的立方和。

计算任务被分解为100个任务，每个任务仅用于计算单独的立方和。Master产生固定个数的worker来处理所有这些子任务。
Worker不断地从任务集体集合中取得这些计算立方和的子任务，并将计算结果返回给Master.Master负责将所有worker累加，
从而产生最终的结果。在计算过程中，Master和Worker的运行也是完全异步的,Master不必等所有的Worker都执行完成后，
就可以进行求和操作。Master在获得部分子任务结果集时，就可以开始对最终结果进行计算，从而进一步提高系统的并行度和吞吐量
 */
import java.util.Map;
import java.util.Set;


public class TestMasterWorker {
    // 使用5个Worker，并指定Worker
    public class PlusWorker extends Worker {

        @Override //实现业务逻辑
        public Object handle(Object input) {
            Integer i = (Integer) input;
            return i * i * i;
        }
    }


    public void testMasterWorker() {
        Master m = new Master(new PlusWorker(), 5);
        // 提交100个子任务
        for (int i = 0; i < 100; i++) {
            m.submit(i);
        }
        // 开始计算
        m.execute();
        // 最终计算结果保存于此
        int re = 0;
        Map<String, Object> resultMap = m.getResultMap();
        while (resultMap.size() > 0 || !m.isComplete()) {
            // 不需要等待所有Worker都执行完，即可开始计算最终结果
            Set<String> keys = resultMap.keySet();
            String key = null;
            for (String k : keys) {
                key = k;
                break;
            }
            Integer i = null;
            if (key != null) {
                i = (Integer) resultMap.get(key);
            }
            if (i != null) {
                re += i;
            }
            if (key != null) {
                // 移除已经被计算过得项
                resultMap.remove(key);
            }
        }

        System.out.println("testMasterWorker:" + re);
    }

    public void testPlus() {
        int re = 0;
        for (int i = 0; i < 100; i++) {
            re += i * i * i;
        }
        System.out.println("testPlus:" + re);
    }

    public static void main(String[] args) {
        new TestMasterWorker().testMasterWorker();
        new TestMasterWorker().testPlus();
    }
}