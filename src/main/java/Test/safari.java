package Test;

/**
 * Created by wushang on 15/9/14.
 */
public class safari {
    private final static String BROWSER_NAME = "Safari";
    private final char[] DILIMITERS = new char[] {' ', ')'};
    private final static int KEYWORD_LENGTH = BROWSER_NAME.length();

    /* (non-Javadoc)
     * @see com.networkbench.newlens.datacollector.browser.uamatcher.Matcher#match(java.lang.String, com.networkbench.newlens.datacollector.browser.uamatcher.UserAgentInfo, int)
     */
    public void match(String userAgent, int beginIndex) {

        int versionIndex = userAgent.indexOf(" Version/");
        if(versionIndex == -1) {
            beginIndex += KEYWORD_LENGTH;
            if(beginIndex >= userAgent.length())
                return;

            if(userAgent.charAt(beginIndex) == '/') {
                String browserVersion = StringUtils.getNextToken(userAgent, DILIMITERS, ++beginIndex, 16, true);
                System.out.println("version1:" + browserVersion);
            }
        } else {
            //preferablly
            String browserVersion = StringUtils.getNextToken(userAgent, DILIMITERS, versionIndex + 9, 16, true);
            System.out.println("version2:" + browserVersion);

        }
    }

    public static void main(String args[]) {
        String browser = "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_5; de-de) AppleWebKit/534.15+ (KHTML, like Gecko) Version/5.0.3 Safari/533.19.4";
        new safari().match(browser, 0);
    }
}
