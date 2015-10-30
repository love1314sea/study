package 其他;


import java.util.UUID;

public class _01_UUID {
    public static void main(String[] args) {
        //纳秒级别，时空唯一
        System.out.println(UUID.randomUUID());
        System.out.println(UUID.randomUUID());

        System.out.println(UUID.randomUUID());
        System.out.println(UUID.randomUUID());

        System.out.println(UUID.randomUUID().toString());

    }
}
