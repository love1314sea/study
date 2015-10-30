package 多线程.线程通信.生产者消费者;



class DecreaseThread extends Thread {
    private Sample sample;
    public DecreaseThread(Sample sample) {
        this.sample = sample;
    }
    public void run() {
        for(int i=0; i<10; ++i) {
            try {
                Thread.sleep((long)(Math.random()*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sample.decrease();
        }
    }
}