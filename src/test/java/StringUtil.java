import java.util.ArrayList;
import java.util.Collection;
import java.util.StringTokenizer;

/**
 * Created by wushang on 15/9/18.
 */
public class StringUtil {
    public static String[] tokenizeToStringArray(String str, String delimiters) {
        return tokenizeToStringArray(str, delimiters, true, true);
    }

    public static String[] tokenizeToStringArray(String str, String delimiters, boolean trimTokens, boolean ignoreEmptyTokens) {
        StringTokenizer st = new StringTokenizer(str, delimiters);
        ArrayList tokens = new ArrayList();

        while(true) {
            String token;
            do {
                if(!st.hasMoreTokens()) {
                    return toStringArray(tokens);
                }

                token = st.nextToken();
                if(trimTokens) {
                    token = token.trim();
                }
            } while(ignoreEmptyTokens && token.length() <= 0);

            tokens.add(token);
        }
    }
    public static String[] toStringArray(Collection collection) {
        return collection == null?null:(String[])((String[])collection.toArray(new String[collection.size()]));
    }
}
