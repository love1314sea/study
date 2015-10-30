package 类._05_Runtime类;


public class _02_内存管理 {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long total = runtime.totalMemory();
        long free = runtime.freeMemory();
        System.out.println("total=" + total + ": free= " + free);
        Integer[] someints = new Integer[1000];
        System.out.println("free2 = " + runtime.freeMemory());
        runtime.gc();
        System.out.println("after gc free3 = " + runtime.freeMemory());

        for(int i=0;i<1000;++i){
            someints[i] = new Integer(i);
        }
        System.out.println("free4 = " + runtime.freeMemory());
        for(int i=0; i<1000; i++) someints[i] = null;
        runtime.gc();
        System.out.println("free5 = " + runtime.freeMemory());
    }
}
