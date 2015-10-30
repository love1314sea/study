package 设计模式._02_策略模式._02;


class Student {

    public int id;
    public int age;
    public String name;
    
    public Student( int id, int age, String name){
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return id+":"+age+":"+name;
    }
}
