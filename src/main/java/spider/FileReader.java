package spider;

/**
 * Created by wushang on 16/5/6.
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;


public class FileReader {
    private String fileName;

    public FileReader() {
    }


    public FileReader(String fileName) {
        this.fileName = fileName;
    }
//
//    　　/**
//     　　* 读取链接，返回一个List
//     　　* @return
//     　　*/
//            　　

    public List getLines() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(this.fileName)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List lines = new LinkedList();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return lines;
    }
}