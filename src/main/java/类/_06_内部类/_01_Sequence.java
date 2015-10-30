package 类._06_内部类;

interface Selector {
    boolean end();
    Object current();
    void next();
}
public class _01_Sequence {
    private Object[] items;
    private int next = 0;

    public _01_Sequence(int size) {
        items = new Object[size];
    }
    public void add(Object x) {
        if(next < items.length)
            items[next++] = x;
    }
    public class SequenceSelector implements Selector {
        private int i = 0;

        @Override
        public boolean end() {
            return i == items.length;
        }
        @Override
        public Object current() {
            return items[i];
        }
        @Override
        public void next() {
            if(i < items.length) i++;
        }
    }
    public Selector selector() {
        return new SequenceSelector();
    }
    public static void main(String[] args) {
        _01_Sequence sequence = new _01_Sequence(10);
        for(int i=0; i<10; i++)
            sequence.add(Integer.toString(i));
        Selector selector = sequence.selector();
        while( !selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}
