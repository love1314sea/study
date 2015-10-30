package IO._07_RandomAcess;


public class _01_字符编码 {
    public static void main(String[] args) throws Exception {
        String s = "吴尚ABC";//使用java默认字符集和编码
        byte[] bytes = s.getBytes();//转换成字节序列，用的是当前项目用的编码 //转换成字节数组，即二进制；每一个汉子对应什么二进制？当然看当前的字符编码
        //当前是utf-8编码，中文占用3个字节，英文占用1个字节
        for(byte b : bytes) {
            System.out.print(Integer.toHexString(b) + " ");
        }
        System.out.println();
        for(byte b : bytes) {
            //把字节（转换成了int，前面24位补0），以16进制的方式显示，& 0xff把前面24位去掉，只留下后八位
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println();
        byte[] bytes1 = s.getBytes("gbk");//gbk中文占用2个字节，英文占用1个字节
        for(byte b : bytes1) {
            System.out.print(Integer.toHexString(b & 0xff ) + " ");
        }
        System.out.println();
        byte[] bytes2 = s.getBytes("utf-16be");//java使用这种双字节编码，汉子和英文都占两个字符
        for(byte b : bytes2) {
            System.out.print(Integer.toHexString(b & 0xff ) + " ");
        }
        /*
        当你的字节序列是某种编码时，这个时候想把字节序列变成字符串，也需要使用这种编码方式，否则会出现乱码
         */
        System.out.println();
        System.out.println(new String(bytes1));//bytes1是gbk编码；生成字符串会使用项目默认的编码，不一致打印乱码
        System.out.println(new String(bytes1,"gbk"));
        /*
        文本文件就是字节序列，可以是任意编码的字节序列

        不同编码项目间，文件粘贴，会有乱码；但文字内容复制粘贴，会自动转换，不会出现乱码
        在中文机器上直接创建文件，那么该文本文件只认识ansi编码；但把其他编码的文件拷过来，也能认识。
         */
    }
}
