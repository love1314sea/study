package 设计模式.适配器模式.demo1;

/**
 * Created by wushang on 15/7/5.
 */
public class Adapter_面向对象 implements Job {
    Person person;
    public Adapter_面向对象(Person person) {
        this.person = person;
    }
    @Override
    public void speakEnglish() {
        person.speakEnglish();
    }

    @Override
    public void speakFranch() {
        person.speakJapanese();
    }

    @Override
    public void speakJapanese() {
        System.out.println("I can speak Franch!");
    }
}
