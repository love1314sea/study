package Collection.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by wushang on 2017/12/29.
 */
public class _05_List的迭代器 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("1");
		list.add("2"); //#index=1
		list.add("3");
		list.add("4");
		list.add("5");
		ListIterator<String> listIterator  = list.listIterator();
		System.out.println(listIterator.next());//1
//		listIterator.set("9");
		System.out.println(listIterator.previous());//还是1
		System.out.println(listIterator.next());//还是1

		Iterator<String> iterator = list.iterator();
//		iterator.

	}
}
