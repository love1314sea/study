package Collection.Queue;

/**
 * Created by wushang on 2017/4/10.
 */
public class _01_test {

	public static int getParent(int k) {
		int parent = (k - 1) >>> 1; //先找到它的parent
		return parent;
	}

	public static void main(String[] args) {
		System.out.println("i=" + 1 + " :parent:" +getParent(1));
		System.out.println("i=" + 2 + " :parent:" +getParent(2));
		System.out.println("i=" + 3 + " :parent:" +getParent(3));
		System.out.println("i=" + 4 + " :parent:" +getParent(4));
		System.out.println("i=" + 5 + " :parent:" +getParent(5));
		System.out.println("i=" + 6 + " :parent:" +getParent(6));
		System.out.println("i=" + 7 + " :parent:" +getParent(7));
		System.out.println("i=" + 8 + " :parent:" +getParent(8));
		System.out.println("i=" + 9 + " :parent:" +getParent(9));
	}
}
