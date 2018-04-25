package jmx.MBean;

/**
 * Created by wushang on 2017/3/26.
 */
public interface HelloMBean {

	public void sayHello();

	public int add(int x, int y);

	public String getName();

	public int getCacheSize();

	public void setCacheSize(int size);
}

