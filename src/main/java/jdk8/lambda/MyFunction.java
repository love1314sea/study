package jdk8.lambda;

/**
 * @author wushang@tingyun.com
 * @date 2018/4/27
 */
@FunctionalInterface
public interface MyFunction {
    public String getValue(String string);

    default String getKey(){
        return "aa";
    }
}


