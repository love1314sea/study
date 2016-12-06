package 性能分析;

import java.util.ArrayList;
import java.util.List;

public class _01_hprof_test {
	public void slowMethod() {
		try {
			List<String> list = new ArrayList<>(100);
			for(int i=0; i<100; i++){
				list.add("hello world :" +i);
			}
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void slowerMethod() {
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		_01_hprof_test test = new _01_hprof_test();
		test.slowerMethod();
		test.slowMethod();
	}
}