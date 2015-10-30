package 多线程.线程通信.生产者消费者;

//wait和notify成对出现。在object类中定义，因此所有的类都会继承，但是final的，无法重载
//这个两个方法在调用时，线程应该已经获得了对象的锁，因此这两个方法调用需要放在synchronized方法或块中。
// notify(); //唤醒的不知道是哪个线程，这里我有个疑问？如果唤醒的还是消费线程，会不会产生死锁？实验中不会。为什么？
/*
sleep不会释放锁；wait会释放锁
 */
class Sample {
    private int number;
    public synchronized void increase()  {
        while( 1 == number) { //如果等于1，就不生产，进入等待。注意这里的while，每次唤醒，都要判断一次
            try {
                System.out.println("1---increase");
                wait(); //wait的时候，会释放锁(sleep会持有锁)；等获得通知并再次得到锁后，再往下执行
                System.out.println("---increase");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number++;
        System.out.println(number);
        notify(); //唤醒的不知道是哪个线程，
    }
    public synchronized void decrease()  {
        while(0 == number) {//如果等于0，就不消费，进入等待。
            try {
                System.out.println("1---decrease");
                wait();
                System.out.println("---decrease");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number--;
        System.out.println(number);
        notify();
    }
}
