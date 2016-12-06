package 并发编程;

import java.sql.SQLException;
import java.util.concurrent.*;

/**
 * Created by wushang on 15/6/16.
 */
/*
Callable+Future 获取子线程的返回结果
 */

class Task01 implements Callable<Integer> {
	public Integer call() throws Exception {
		Thread.sleep(3000);
		return 100;
	}
}

public class _01_Test {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		int startIndex = 0;
		int endIndex = 0;
		int SQL_BATCH_COUNT = 110;
		int size = 105;
//		for (int i = 0; i < size; ++i) {
//			if ((i + 1) % SQL_BATCH_COUNT == 0) {
//				endIndex = i;
//				startIndex = endIndex - SQL_BATCH_COUNT + 1;
//				System.out.println("start=" + startIndex + ",end=" + endIndex );
//			} else if ((i + 1) == size) {
//				startIndex = (endIndex == 0 ? 0: endIndex+1);
//				endIndex = i;
//				System.out.println("-- start=" + startIndex + ",end=" + endIndex );
//
//			}
//		}

		for (int i = 0; i < size; ++i) {
			if ((i + 1) % SQL_BATCH_COUNT == 0) {
				System.out.println("exe---");
				startIndex += SQL_BATCH_COUNT ;
				System.out.println("start=" + startIndex  );
			} else if ((i + 1) == size) {
				System.out.println("exe2---");
				System.out.println("-- start=" + startIndex  );

			}
		}
	}
}
