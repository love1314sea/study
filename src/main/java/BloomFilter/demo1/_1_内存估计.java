package BloomFilter.demo1;

/**
 * Created by wushang on 15/6/28.
 */
/*
直接利用前人的结论：

http://www.cnblogs.com/kaituorensheng/p/3669140.html
其中f'是自己期望的误判率，m是总共开辟的存储空间位数，n是待存储字符串的个数，k是哈希函数的个数，f是真正的误判率。

 */
public class _1_内存估计 {

    public static double log(double value, double base) {
        return Math.log(value) / Math.log(base);
    }

    public static double getHashBits(Long elementNum, Double expectedPF) {
        return Math.log(1/expectedPF)/Math.log(2)*elementNum*1.44;
    }
    public static double getHashMapNum(Long hashBits, Long elementNum) {
        return hashBits/elementNum*0.693;
    }
//    public static double getTruePF()
    public static void main(String[] args) {
        long elementNum = 20000000;
        double expectedPF = 0.01D;

        long hashBits = (long)getHashBits(elementNum, expectedPF);
        System.out.println("hash需要存储空间位数:" + hashBits + " 占用:" + hashBits/8/1024/1024 +"M");


        double hashMapNum = getHashMapNum(hashBits,elementNum);
        System.out.println("需要的hash个数为:" + hashMapNum);

    }
}
