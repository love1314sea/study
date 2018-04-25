package 日期时间;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wushang on 15/11/18.
 */
public class _02_时间格式转换 {
    private final static DateFormat DATE_FORMAT = new SimpleDateFormat("YYYYMMddHH");


    public static String getParentDirPath(String exportPathPara, long timestamp) {
        String exportPath = exportPathPara;
        if (exportPath == null) {
            exportPath = ".";
        } else if (!exportPath.endsWith(File.separator)) {
            exportPath += File.separatorChar;
        }
        Date date = new Date(timestamp);
        String dateStr = DATE_FORMAT.format(date);
        String ymd = dateStr.substring(0, 8);
        String hour = dateStr.substring(8);
        StringBuilder sbParentDirPath = new StringBuilder(exportPath);
        sbParentDirPath.append(ymd).append(File.separatorChar);
        String period = "minute";
        if (period.endsWith("day")) {
            ;
        } else { //hour 或 minute
            sbParentDirPath.append(hour).append(File.separatorChar);
        }
        sbParentDirPath.append("NL_APP_WEB_ACTION").append(File.separatorChar);
        String parentDirPath = sbParentDirPath.toString();
        Path parentDir = Paths.get(parentDirPath);

        return parentDirPath;
    }

    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String s = dateFormat.format(date);
        System.out.println(s);

        String s2 = "2015-11-18 15:31:43";
        Date date2 = dateFormat.parse(s2);
        System.out.println(date2);
        System.out.println("1-------");
        System.out.println(getParentDirPath("/abc/def/", System.currentTimeMillis()));
    }
}
