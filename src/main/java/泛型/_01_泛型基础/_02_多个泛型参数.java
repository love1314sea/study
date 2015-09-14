package 泛型._01_泛型基础;

/*
1 泛形要求能包容的是引用类型，不能使用基本类型,因为泛型的类型限制，默认为<T extends Object>
 */
public class _02_多个泛型参数 {

    public static void main(String[] args) {
        //Integer不能换为int，泛形要求能包容的是引用类型，不能使用基本类型
        Generic<String, Integer> g1 = new Generic<String, Integer>("zhang", 15);
        String name = g1.getName();
        int age = g1.getAge();
        System.out.println(name + ":" + age);
    }
}

class Generic<T1, T2> {
    private T1 name;
    private T2 age;

    public Generic(T1 name, T2 age) {
        this.name = name;
        this.age = age;
    }

    public T1 getName() {
        return name;
    }


    public void setName(T1 name) {
        this.name = name;
    }

    public T2 getAge() {
        return age;
    }

    public void setAge(T2 age) {
        this.age = age;
    }
}

