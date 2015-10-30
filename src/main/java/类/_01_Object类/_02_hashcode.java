package 类._01_Object类;

/*
hashCode方法和equals方法有很大的关联性:
1 如果两个对象 equals方法相同,则hashCode方法得到的整数也必须相同
2 但是,如果两个对象hashCode相同,但equals方法不一定相同.
3 对于object类的对象,不同的对象会返回不同的hashCode值
4 在java应用的一次执行过程当中，对于同一个对象的hashCode方法的多次调用，应该返回相同的值．
5 一般hashCode()和equals()方法，一个重写了，也要重写另外一个
 */
public class _02_hashcode {
}
