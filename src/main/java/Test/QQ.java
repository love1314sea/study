package Test;

/**
 * Created by wushang on 15/9/14.
 */
public class QQ {

    private final static String BROWSER_NAME = "QQBrowser";
    private final static int BROWSER_LENTH = BROWSER_NAME.length();
    private final char DILIMITER = ' ';

    public void match(String userAgent, int beginIndex) {
        beginIndex += BROWSER_LENTH;
        if (beginIndex >= userAgent.length())
            return;
        if (userAgent.charAt(beginIndex) == '/') {
            String browserVersion = StringUtils.getNextToken(userAgent, DILIMITER, ++beginIndex, 16, true);
            System.out.println(browserVersion);

//            System.out.println(userAgent.substring(beginIndex+1));
        }
    }

    public static int tryMatch(String userAgent) {
        return userAgent.indexOf(BROWSER_NAME);
    }
    public static void main(String[]  args) {
        String browser = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.69 Safari/537.36 QQBrowser/9.1.3471.400";
        new QQ().match(browser,tryMatch(browser) );
    }
}
