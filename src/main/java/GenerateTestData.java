import java.io.*;
import java.nio.Buffer;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wushang on 2017/3/28.
 */
public class GenerateTestData {

	public static void main(String[] args) throws InterruptedException {


		int lineNum = 2000000;
		int threadNum = 2;
		String path = "/Users/wushang/Downloads/spark/testfile";
		CountDownLatch latch = new CountDownLatch(threadNum);
		ExecutorService es = Executors.newFixedThreadPool(threadNum);

		for (int i = 1; i <= threadNum; ++i) {
			es.execute(new WriteTask(path, i, lineNum, latch));
		}
		latch.await();
		es.shutdown();
	}
}

class WriteTask extends Thread {
	Random random = new Random();
	int timestamp = (int) (System.currentTimeMillis() / 1000);
	int appId = 100;
	int threadId;
	int times;
	String path;
	CountDownLatch latch;

	private String getRandUrl() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 500; ++i) {
			sb.append(getRandomChar());
		}
		return sb.toString();
	}

	private int getRandomCount() {
		return random.nextInt(50000000);
	}

	private char getRandomChar() {
		return (char) (random.nextInt(58) + 65);
	}

	public WriteTask(String path, int threadId, int times, CountDownLatch latch) {
		this.threadId = threadId;
		this.times = times;
		this.path = path;
		this.latch = latch;
	}

	private String getContent() {
		StringBuilder sb = new StringBuilder();
		sb.append(appId).append("\t")
				.append(getRandUrl()).append("\t")
				.append(getRandomCount()).append("\n");
		return sb.toString();
	}

	@Override
	public void run() {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path + "/b-" + threadId)));
			for (int i = 0; i < times; ++i) {
				bw.write(getContent());
			}
			latch.countDown();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}