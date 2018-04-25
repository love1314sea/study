package Collection.List;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wushang on 2017/12/28.
 */
/*
三种遍历:
1 for(int i=0; i<list.size;++i)  #删除不报错, 但遍历不完全,会遗漏下一个元素
2 for(String s:list) #遍历删除时会报错
3 迭代器 #可以删除
参考:http://elim.iteye.com/blog/1523785
 */
public class _04_ArrayList的删除 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2"); //#index=1
		list.add("3");
		list.add("4");
		list.add("5");

		for (int i = 0; i < list.size(); ++i) {
			System.out.println(i);
			System.out.println("v1=" + list.get(i));

			if (list.get(i).equals("2")) {
				list.remove(i);
			}
			System.out.println("v2=" + list.get(i));
		}


//		for(String s : list) {
////			if (s.equals("3")) {
//				list.remove(3);
////			}
//			System.out.println(s);
//		}
		int oldCapacity = 5;
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		System.out.println(newCapacity);

	}
}
