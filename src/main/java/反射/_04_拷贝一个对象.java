package 反射;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class _04_拷贝一个对象 {
    public  Object copy(Object object) throws Exception {
        Class<?> classType = object.getClass();
        Constructor cons = classType.getConstructor(new Class[]{});
        Object copyObject = cons.newInstance(new Object[]{});
        Field[] fields = classType.getDeclaredFields();//不能使用getFields()
        for(Field field: fields) {
            String member = field.getName();
            String firstLetter = member.substring(0,1).toUpperCase();
            String getMethodName = "get" + firstLetter + member.substring(1);
            String setMethodName = "set" + firstLetter + member.substring(1);
            Method getMethod = classType.getMethod(getMethodName, new Class[]{});
            Method setMethod = classType.getMethod(setMethodName, new Class[]{field.getType()});//Field类返回class使用getType
            Object value = getMethod.invoke(object,new Object[]{});
            setMethod.invoke(copyObject, new Object[]{value});
        }
        return copyObject;
    }
    public static void main(String[] args) throws Exception {
        Customer customer = new Customer("zhang", 15);
        customer.setId(2L);//int会自动装箱为Integer; long自动装箱为Long

        _04_拷贝一个对象 test = new _04_拷贝一个对象();
        Customer customer1 = (Customer)test.copy(customer);//需要类型转换
        System.out.println(customer1.getId() + ":" + customer1.getName()+":" + customer1.getAge());
    }
}
class Customer{
    private Long id;
    private String name;
    private int age;

    public Customer() { //反射newInstance调用，要求是public的方法
    }
    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}