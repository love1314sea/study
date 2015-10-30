package 设计模式._04_代理模式._03_自己改进的动态代理;
/*
真实角色：是我们最终要引用的对象，要调用的方法
 */

class RealSubject extends Subject {
    @Override
    public void request() {
        System.out.println("From real subject");
    }
}


class RealSubject2 extends Subject {
    @Override
    public void request() {
        System.out.println("From real subject2");
    }
}
