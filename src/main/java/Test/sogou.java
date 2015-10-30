package Test;

/**
 * Created by wushang on 15/9/14.
 */
public class sogou {
    private final static String BROWSER_NAME = "SE";

    public void match(String userAgent, int beginIndex) {
        beginIndex +=3;
        if (beginIndex >= userAgent.length())
            return;
        System.out.println(userAgent.substring(beginIndex));
    }

    public static int tryMatch(String userAgent) {
        return userAgent.indexOf(BROWSER_NAME);
    }
    public static void main(String[] args) {
        String browser="Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/38.0.2125.122 Safari/537.36 SE ";
        new sogou().match(browser,tryMatch(browser));
    }
}
