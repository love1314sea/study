package commons.io.file;

import kafka.tools.StateChangeLogMerger;
import org.apache.commons.io.FileSystemUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOCase;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;

/**
 * Created by wushang on 15/7/3.
 */
public class _02_ {
    public static void main(String[] args) throws IOException {
        //1 读取文件内容
        File file = FileUtils.getFile("/Users/wushang/IdeaProjects/study/src/main/java/commons/io/UtilityExample.java");
        LineIterator lineIterator = FileUtils.lineIterator(file);
        while(lineIterator.hasNext()) {
            System.out.println(lineIterator.next());
        }
        lineIterator.close();
        //2 目录下是否包含某一个文件
        File parentDir = FileUtils.getFile("/Users/wushang/IdeaProjects/study/src/main/java/commons/io");
        File chileFile = FileUtils.getFile("is.java");
        System.out.println(FileUtils.directoryContains(parentDir,chileFile));

//        new FileAlterationListenerAdaptor
        FileAlterationObserver observer = new FileAlterationObserver(parentDir);
//        observer.addListener();
        FileAlterationMonitor monitor = new FileAlterationMonitor(500, observer);

    }
}
