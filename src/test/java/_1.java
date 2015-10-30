/**
 * Created by wushang on 15/10/22.
 */
public class _1 {
    public static void main(String[] args) {

        String methodAndXhrUrl = "get  http//baidu.com";
        String method = "GET";
        String xhrUrl = "";
        int index = methodAndXhrUrl.indexOf(" http");
        if(index < 0) {
            xhrUrl = methodAndXhrUrl;
        } else {
            method = methodAndXhrUrl.substring(0, index).toUpperCase()+"*";
            xhrUrl = methodAndXhrUrl.substring(index+1);
        }

        System.out.println("method=" + method);
        System.out.println("url=" + xhrUrl);
    }
}
