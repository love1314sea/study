package 类._05_Runtime类;

/*
Runtime类封装了运行时的环境。
每个 Java 应用程序都有一个 Runtime 类实例，使应用程序能够与其运行的环境相连接。
一旦得到了一个当前的Runtime对象的引用，就可以调用Runtime对象的方法去控制Java虚拟机的状态和行为。
 */

import java.io.IOException;

public class _01_执行其他程序 {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        Process process = null;
        try {
            process = runtime.exec("notepad");//起一个子进程去执行命令
            process.waitFor();//可以选择等待子进程结束
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("return value=" + process.exitValue());
    }
}
