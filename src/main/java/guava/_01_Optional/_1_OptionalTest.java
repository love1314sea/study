package guava._01_Optional;

import com.google.common.base.Optional;
/*
http://www.cnblogs.com/peida/archive/2013/06/14/guava_optional.html

http://www.cnblogs.com/icejoywoo/archive/2012/06/20/2556930.html
 */

public class _1_OptionalTest {

    public static void testOptional() throws Exception {

        Optional<Integer> possible = Optional.of(6); //of,不能包含null
        //absent, 获得一个Optional对象，其内部为空值
        Optional<Integer> absentOpt = Optional.absent();

        //fromNullable 可以为空，也可以不为空
        Optional<Integer> NullableOpt = Optional.fromNullable(null);
        Optional<Integer> NoNullableOpt = Optional.fromNullable(10);

        if (possible.isPresent()) {
            System.out.println("1------");
            System.out.println("possible isPresent:" + possible.isPresent());
            System.out.println("possible value:" + possible.get());
        }

        if (!absentOpt.isPresent()) {
            System.out.println("2------");
            System.out.println("absentOpt isPresent:" + absentOpt.isPresent());
            ;
        }

        if (!NullableOpt.isPresent()) {
            System.out.println("3------");
            System.out.println("fromNullableOpt isPresent:" + NullableOpt.isPresent());
            ;
        }

        if (NoNullableOpt.isPresent()) {
            System.out.println("4------");
            System.out.println("NoNullableOpt isPresent:" + NoNullableOpt.isPresent());
            ;
        }
    }

    public static void main(String[] args) throws Exception {
        testOptional();
    }
}