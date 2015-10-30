import javafx.scene.control.Tab;

/*
1 构造对象时，先要初始化后成员变量，然后再调用构造函数
2 静态成员变量在普通成员变量前初始化，且多个对象也只初始化一次（即生成第一个对象时初始化，以后不再初始化)
3 生成对象的时候才进行初始化工作，声明的时候不进行。

 */
public class _04_成员变量的初始化顺序 {
    public static void main(String[] args){
        System.out.println("Creating new Cupboard() in main");
      //  new CupBoard();
        System.out.println("Creating new Cupboard() in main");
        CupBoard.test();
      //  new CupBoard();
     //   table.f2(1);
     //   cupBoard.f3(1);
    }
 //   static Table table1;//只声明，即使Table中有static变量，也不进行初始化工作
  //  static Table table = new Table();
   // static CupBoard cupBoard = new CupBoard();
}
class Bowl {
    public Bowl(int mark) {
        System.out.println("Bowl(" + mark + ")")    ;
    }
    void f1(int mark){
        System.out.println("f1( " + mark +")");
    }
}
class Table {
    static Bowl bowl1 = new Bowl(1); //先构造成员变量，再执行构造函数


    public Table() {
        System.out.println("Table()");
        bowl2.f1(1);
    }
    public void f2(int mark) {
        System.out.println("f2(" + mark +")");
    }

    static Bowl bowl2 = new Bowl(2);
}
class CupBoard{
    Bowl bowl3 = new Bowl(3);
    static Bowl bowl4 = new Bowl(4); //2 静态成员变量在普通成员变量前初始化，且多个对象也只初始化一次
    static void test() {
        System.out.println("table test");
    }
    public CupBoard() {
        System.out.println("CupBoard()");
        bowl4.f1(2);
    }
    public void f3(int mark) {
        System.out.println("f3(" + mark + ")");
    }
    static Bowl bowl5 = new Bowl(5);
}