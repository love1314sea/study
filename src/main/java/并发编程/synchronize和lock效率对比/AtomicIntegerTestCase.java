package 并发编程.synchronize和lock效率对比;

/**
 * Created by wushang on 16/10/3.
 */

/**
 * @author YHJ create at 2013-4-26 下午05:58:32
 * @Described：原子int类型操作测试用例
 * @ClassNmae com.yhj.lock.AtomicIntegerTestCase
 */
public interface AtomicIntegerTestCase {

	/**
	 * ++并返回
	 *
	 * @return
	 * @Author YHJ create at 2013-4-26 下午05:39:47
	 */
	int incrementAndGet();

	/**
	 * 取值
	 *
	 * @return
	 * @Author YHJ create at 2013-4-26 下午05:39:56
	 */
	int get();
}