package jdk8.日期时间;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author wushang@tingyun.com
 * @date 2018/5/2
 */
public class _02_ {

    public static void main(String[] args) {

        //1 获取时间戳
        System.out.println(Clock.systemDefaultZone().millis());
        System.out.println(System.currentTimeMillis());
        System.out.println(Instant.now().toEpochMilli());

        //2
        Instant instant = Instant.now();
        System.out.println(instant);//注意：返回的是 UTC 时间
        System.out.println(Instant.ofEpochSecond(1000000));//用 秒 来生成

        //3
        LocalDateTime dateTime = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));//当前时区时间
        System.out.println(dateTime);
        LocalDateTime dateTime1 = LocalDateTime.of(2015, 12, 5, 14, 2, 1);
        System.out.println(dateTime1);

        System.out.println("==================");

        //4 格式化类
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");//定义格式
        //正反都能调用: 1  将 datatime 转换成指定格式的字符串
        String s = LocalDateTime.now().format(formatter);
        System.out.println(s);
        s = formatter.format(LocalDateTime.now());
        System.out.println(s);

        //将 日期时间字符串 转换成 DateTime对象
        LocalDateTime dateTime2 = LocalDateTime.now().parse(s, formatter);
        System.out.println(dateTime2);


    }
}
