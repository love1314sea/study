//package 设计模式._01_单例模式;
//
//import java.io.Console;
//
//public class Program {
//    private static void Main(string[] args) {
//
//        GetInstance();
//        Console.ReadLine();
//    }
//
//    private void GetInstance() {
//        Singleton objectSingleton = Singleton.getInstance();
//    }
//}
//
//public class Singleton {
//    private static Singleton instance = null;
//
//    private Singleton() {
//    }
//
//    public static Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//            Console.WriteLine("Create a singleton instance!");
//        }
//        return instance;
//    }
//}