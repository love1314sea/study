package spider;

/**
 * Created by wushang on 16/5/6.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Administrator
 */


public class Url {

    private String url;


    public Url() {
    }


    public Url(String url) {
        this.url = url;
    }


    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获得链接
     *
     * @return
     */


    public URLConnection getConnection() {
        URL httpUrl = null;
        try {
            httpUrl = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        URLConnection conn = null;
        if (httpUrl != null) {
            try {
                conn = httpUrl.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    /**
     * 获得链接上的输出流
     *
     * @return
     */


    public BufferedReader getReader() {
        URLConnection conn = getConnection();
        BufferedReader br = null;
        if (conn == null) {
            return null;
        }
        conn.setConnectTimeout(9000);
        try {
            conn.connect();
            //读取html文件内容
            br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return br;
    }

    /**
     * 从输出流中一行一行读取文件，查看是否含有str字符串，有就返回真
     *
     * @param str
     * @return
     */


    public boolean isExist(String str) {
        BufferedReader bis = getReader();
        boolean exist = false;
        String line = null;
        try {
            while ((line = bis.readLine()) != null) {
                System.out.println(line);
                exist = line.contains(str);
                if (exist) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return exist;
    }


}