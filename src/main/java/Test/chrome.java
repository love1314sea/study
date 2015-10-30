package Test;

/**
 * Created by wushang on 15/9/14.
 */
public class chrome {
    private final static String BROWSER_NAME = "Chrome";
    private final char DILIMITER = ' ';

    /* (non-Javadoc)
     * @see com.networkbench.newlens.datacollector.browser.uamatcher.Matcher#match(java.lang.String, com.networkbench.newlens.datacollector.browser.uamatcher.UserAgentInfo, int)
     */
    public void match(String userAgent,  int beginIndex) {

        beginIndex += 6;
        if(beginIndex >= userAgent.length())
            return;
        if(userAgent.charAt(beginIndex) == '/') {
            String browserVersion = StringUtils.getNextToken(userAgent, DILIMITER, ++beginIndex, 16, true);
            System.out.println("version:"  + browserVersion);
        }
    }

    /* (non-Javadoc)
     * @see com.networkbench.newlens.datacollector.browser.uamatcher.Matcher#tryMatch(java.lang.String)
     */
    public static int tryMatch(String userAgent) {
        return userAgent.indexOf(BROWSER_NAME);
    }
    public static void main(String args[]) {
        String browser = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.85 Safari/537.36";
        new chrome().match(browser, tryMatch(browser));
    }
}
