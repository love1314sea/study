package 设计模式._02_策略模式._03;


class Student {

    private int id;
    private int age;
    private String name;
    
    public Student(int id, int age, String name){
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return id+":"+age+":"+name;
    }
}
