
/*
break 跳出一层循环, 不再进入循环;
continue: 跳出一层循环,继续进入循环
就相当于一层循环外有个标签,他们跳到标签处.
 */
public class _1_break和continue {

	private static void continueTest() {


//		for (int i = 0; i < 10; i++) {//循环1
//			Label:
//			for (int j = 0; j < 10; j++) {// 循环2
//				if (j == 5)
//					continue Label;
//				System.out.println("i=" + i + ", j=" + j);
//			}
//		}

		//continue 只跳出一层循环,然后继续:(结果同上)
		for (int i = 0; i < 10; i++) {//循环1
			for (int j = 0; j < 10; j++) {// 循环2
				if (j == 5)
					continue ;
				System.out.println("i=" + i + ", j=" + j);

			}
		}

		//		Label:
//		for (int i = 0; i < 10; i++) {//循环1
//			for (int j = 0; j < 10; j++) {// 循环2
//				if (j == 5)
//					continue Label;
//				System.out.println("i=" + i + ", j=" + j);
//
//			}
//		}
	}

	private static void breakTest() {

//		for (int i = 0; i < 10; i++) {//循环1
//			Label:
//			for (int j = 0; j < 10; j++) {// 循环2
//				if (j == 5)
//					break Label;
//				System.out.println("i=" + i + ", j=" + j);
//
//			}
//		}
//
//
//		for(int i=0; i<10; i++) {
//			for(int j=0; j<10; j++) {
//				if(j ==5)
//					break;// 仅仅调出一层循环, 外层循环继续 (同上)
//				System.out.println("i=" + i + ", j=" + j);
//			}
//		}

		Label:
		for (int i = 0; i < 10; i++) {//循环1
// 标记循环2,break label会跳出 循环2
			for (int j = 0; j < 10; j++) {// 循环2
				if (j == 5)
					break Label;
				System.out.println("i=" + i + ", j=" + j);

			}
		}

	}

	public static void main(String[] args) {
		continueTest();
//		breakTest();
	}
}