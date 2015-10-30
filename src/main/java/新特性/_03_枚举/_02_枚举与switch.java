package 新特性._03_枚举;

enum OpConstant {
    TURN_RIGHT, TURN_LEFT,SHOOT
}
public class _02_枚举与switch {

    public static void doOp(OpConstant opConstant) { //枚举作为函数参数
        switch (opConstant) { //枚举中是switch类型
            case TURN_RIGHT:
                System.out.println("turn right");
                break;
            case TURN_LEFT:
                System.out.println("turn left");
                break;
            case SHOOT:
                System.out.println("shoot ");
                break;
        }
    }
    public static void main(String[] args) {
        doOp(OpConstant.SHOOT);
        doOp(OpConstant.TURN_LEFT);
    }

}
