package commons.io.file;

import org.apache.commons.io.FilenameUtils;

/**
 http://www.importnew.com/13715.html
 */
public class UtilityExample {

    public static final String EXAMPLE_TXT_PATH = "/Users/wushang/IdeaProjects/study/src/main/java/commons/io/UtilityExample.java";

    public static void main(String[] args) {

        System.out.println(FilenameUtils.getFullPath(EXAMPLE_TXT_PATH));
        System.out.println(FilenameUtils.getName(EXAMPLE_TXT_PATH));//文件名
        System.out.println(FilenameUtils.getBaseName(EXAMPLE_TXT_PATH));//文件名不包含扩展名
        System.out.println(FilenameUtils.getExtension(EXAMPLE_TXT_PATH));//拓展名

    }
}
