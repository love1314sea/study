package commons.io.collection;

import com.google.common.collect.*;

import java.util.*;

/**
 https://code.google.com/p/guava-libraries/wiki/CollectionUtilitiesExplained
 */
public class _1 {
    public static void main(String[] args) {
        HashSet<String> hashSet = Sets.newHashSet();
        LinkedHashSet<String> linkedHashSet = Sets.newLinkedHashSet();

        ArrayList<String> arrayList = Lists.newArrayList();
        LinkedList<String> linkedList = Lists.newLinkedList();

        ImmutableSet<Integer> immutableSet = ImmutableSet.of(1, 2, 3);
        ImmutableList<String> immutableList = ImmutableList.copyOf("a,b,c".split(","));
        ImmutableList<String> immutableList2 = ImmutableList.of("a", "b", "c");
    }
}
