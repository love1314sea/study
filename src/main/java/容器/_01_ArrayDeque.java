package 容器;

import java.util.ArrayDeque;
import java.util.Deque;

public class _01_ArrayDeque {

    public static void main(String[] args) {
        Deque<String> stringDeque = new ArrayDeque<>(2);

        stringDeque.addFirst("a");
        stringDeque.addFirst("b");
        stringDeque.addFirst("c");

        System.out.println(stringDeque.pollLast());
        System.out.println(stringDeque.size());

    }
}
