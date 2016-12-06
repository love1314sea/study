import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by wushang on 16/10/17.
 */
public class _01_test {
	private final static TimeZone DEFAULT_TIME_ZONE = TimeZone.getTimeZone("GMT+8");


	private static String normalizeParas(String parasInput) {
		System.out.println("input: " + parasInput);
		String[] paras = parasInput.split("\\,", -1);
		StringBuilder customBuider = new StringBuilder();
		for (int i = 0; i < paras.length; ++i) {
			String para = paras[i];
			int idx = para.indexOf(':');
			if (idx != -1) {
				String k = para.substring(1, idx - 1);//去掉引号
				String v = para.substring(idx + 1);
				if (para.charAt(idx + 1) == '"') {
					v = v.substring(1, v.length() - 1);//如果是字符串,去掉引号
				}
				customBuider.append(k).append("=").append(v);
				if(i != paras.length - 1) {
					customBuider.append("&");
				}
			}
		}
		return customBuider.toString();
	}

	public static void main(String[] args) {
//		String traceDate = "[1476773642,{a},{\"threadName\":\"http-8080-5\",\"httpStatus\":200,\"request.headers.host\":\"reportlocal.tingyun.com\",\"request.headers.accept\":\"application\\/json, text\\/javascript, *\\/*; q=0.01\",\"response.headers.contentType\":\"application\\/json;charset=UTF-8\",\"referer\":\"http:\\/\\/reportlocal.tingyun.com\\/server\\/application\\/126783\\/traceDetail\\/66458671\",\"request.headers.userAgent\":\"Mozilla\\/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit\\/537.36 (KHTML, like Gecko) Chrome\\/53.0.2785.143 Safari\\/537.36\",\"request.headers.contentLength\":\"57\"},[0,9559,\"R";
		String traceDate = "[1394609506183,{\"name\":\"renyp\",\"pwd\":\"123\"},{\"httpStatus\":200,\"threadName\":\"nbs.48\"},[0,831,\"ROOT\",null,1,\"org.apache.catalina.connector.CoyoteAdapter\",\"";
		int index1 = traceDate.indexOf("{");
		int index2 = traceDate.indexOf("}", index1);
		int index3 = traceDate.indexOf("{", index2);
		int index4 = traceDate.indexOf("}", index3);

		String requestParas = "";
		String customParas = "";
		if (index1 > 0 && index2 > 0) {
			requestParas = normalizeParas(traceDate.substring(index1 + 1, index2));
		}
		if (index3 > 0 && index4 > 0) {
			customParas = normalizeParas(traceDate.substring(index3 + 1, index4));
		}

		System.out.println("requestParas: " + requestParas);
		System.out.println("customParas: " + customParas);

		System.out.println("1------");

//		requestParas = "b=d";
//		customParas = "";
		String allParas = requestParas + "&" + customParas;
		if (allParas.charAt(0) == '&') {
			allParas = allParas.substring(1);
		}
		if (allParas.length() > 0 && allParas.charAt(allParas.length() - 1) == '&') {
			allParas = allParas.substring(0, allParas.length() - 1);
		}
		System.out.println("all=" + allParas);
	}
}
