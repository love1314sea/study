package 设计模式.适配器模式.demo1;

public class Person {

    private String name;
    private String sex;
    private int age;

    public void speakJapanese() {
        System.out.println("I can speak Japanese!");
    }

    public void speakEnglish() {
        System.out.println("I can speak English!");
    }
}
