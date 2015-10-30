package spring.demo3;

/**
 * Created by wushang on 15/10/21.
 */
public class PoetciJuggler extends Juggler {
    private Poem poem;

    public PoetciJuggler() {

    }
    public PoetciJuggler(Poem poem) {
        super();
        this.poem = poem;
    }

    public PoetciJuggler(int beanBags, Poem poem) {
        super(beanBags);
        this.poem = poem;
    }

    public void setPoem(Poem poem) {
        this.poem = poem;
    }

    @Override
    public void perform() throws Exception {
        super.perform();//执行完父类的函数
        System.out.println("while reciting........");
        poem.recite();
    }
}
