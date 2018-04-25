package Collection.Queue;

import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * Created by wushang on 2017/4/12.
 */
public class _03_中位数 {
	int mid = -1;
	//smallQueue 存比中位值大的数字:这样能获取最小值
	//bigQueue 存比中位值小的数字:这样能获取最大值
	PriorityQueue<Integer> smallQueue = new PriorityQueue<>();
	PriorityQueue<Integer> bigQueue = new PriorityQueue<Integer>(5, new MyComparator());

	public void put(int v) {

		if (smallQueue.size() == 0 && bigQueue.size() == 0 && mid ==-1) {
			mid = v;
			return;
		}
		if (v >= mid) {
			if (smallQueue.size() - bigQueue.size() == 1) {
				smallQueue.add(v);
				bigQueue.add(mid);
				mid = smallQueue.poll();
			} else {//两个队列相等
				smallQueue.add(v);
			}
		} else {
			if (bigQueue.size() - smallQueue.size() == 1) {//
				bigQueue.add(v);
				smallQueue.add(mid);
				mid = bigQueue.poll();
			} else {//两个队列相等
				bigQueue.add(v);
			}
		}
	}
	public void printMid() {
		if(smallQueue.size() == bigQueue.size())
			System.out.println("mid=" + mid);
		else if(smallQueue.size() > bigQueue.size()) {
			System.out.println("mid=" + mid +"," + smallQueue.peek());
		} else {
			System.out.println("mid=" + mid +"," + bigQueue.peek());
		}
	}

	public static void main(String[] args) {
		_03_中位数 test = new _03_中位数();
		test.put(6);
		test.put(5);
		test.put(4);
		test.put(3);
		test.put(13);
		test.put(2);
		test.put(2);
		test.put(11);
		test.printMid();
	}

}

class MyComparator implements Comparator<Integer> {
	@Override
	public int compare(Integer o1, Integer o2) {
		return o2 - o1;
	}
}