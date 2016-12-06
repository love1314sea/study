package spider;

/**
 * Created by wushang on 16/5/6.
 */

import java.io.IOException;
import java.util.List;

/**
 * @author Administrator
 */
public class Digger extends Thread {
    private Url url;

    public Digger() {
        super();
    }

    public Digger(Url url) {
        this.url = url;
    }

    /**
     * main方法，把配置信息(链接)读入程序，并为每一个链接开启一个线程
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("/Users/wushang/tmp/a.txt");
        List urls = reader.getLines();
        for (Object string : urls) {
            Url url = new Url(string.toString());
            Digger digger = new Digger(url);
            digger.start();
        }
        // Runtime.getRuntime().exec("C:/Program Files/Internet Explorer/iexplore.exe http://www.masamaso.com/index.shtml"); 
    }

    /**
     * 查看该链接是否存在free_msg字段，存在即为金子 用IE打开该链接
     */
    @Override
    public void run() {
        if (url.isExist("free_msg")) {
            try {
                Runtime.getRuntime().exec("C:/Program Files/Internet Explorer/iexplore.exe " + url.getUrl());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(url.getUrl() + "END!");
    }
}