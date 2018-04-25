package Collection.DelayQueue.demo1;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.DelayQueue;

/**
 * Created by wushang on 2017/4/14.
 */
//http://www.cnblogs.com/sunzhenchao/p/3515085.html
public class Exam {

	/**
	 * 2014-1-10 下午9:43:48 by 孙振超
	 *
	 * @param args void
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int studentNumber = 20;
		CountDownLatch countDownLatch = new CountDownLatch(studentNumber + 1);
		DelayQueue<Student> students = new DelayQueue<Student>();
		Random random = new Random();
		for (int i = 0; i < studentNumber; i++) {
			students.put(new Student("student" + (i + 1), 30 + random.nextInt(120), countDownLatch));
		}
		Thread teacherThread = new Thread(new Teacher(students));
		students.put(new EndExam(students, 120, countDownLatch, teacherThread));
		teacherThread.start();
		countDownLatch.await();
		System.out.println(" 考试时间到，全部交卷！");
	}

}
