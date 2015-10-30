package Test;

/**
 * Created by wushang on 15/9/14.
 */
public class _2 {

        private final static String BROWSER_NAME = "Firefox";
        private final char[] DILIMITERS = new char[]{' ', '(', ')', ';'};

        /* (non-Javadoc)
         * @see com.networkbench.newlens.datacollector.browser.uamatcher.Matcher#match(java.lang.String, com.networkbench.newlens.datacollector.browser.uamatcher.UserAgentInfo, int)
         */


        public void match(String userAgent, int beginIndex) {

            beginIndex += 7;
            if (beginIndex >= userAgent.length())
                return;

            char nextChar = userAgent.charAt(beginIndex);
            String browserVersion = "n0";
            switch (nextChar) {
                case '/':
                    browserVersion = StringUtils.getNextToken(userAgent, DILIMITERS, ++beginIndex, 16, true);
                    System.out.println("version1:" + browserVersion);
                    break;
                case ' ':
                    ++beginIndex;
                    nextChar = userAgent.charAt(beginIndex);
                    if (nextChar >= '0' && nextChar <= '9') {
                        browserVersion = StringUtils.getNextToken(userAgent, DILIMITERS, beginIndex, 16, true);
                    }
                    System.out.println("version2" + browserVersion);
                    break;
            }
        }

        /* (non-Javadoc)
         * @see com.networkbench.newlens.datacollector.browser.uamatcher.Matcher#tryMatch(java.lang.String)
         */
        public int tryMatch(String userAgent) {
            return userAgent.indexOf(BROWSER_NAME);
        }

        public static void main(String args[]) {
            new _2().match("Firefox/4.0b9pre", 0);
        }
    }
