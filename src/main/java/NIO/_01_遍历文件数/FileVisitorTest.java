package NIO._01_遍历文件数;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/*
    PostVisitDirectory - 一个路径的所有节点被访问后调用。如果有错误发生，exception会传递给这个方法

    CONTINUE –继续
TERMINATE –终止，这次遍历结束了
SKIP_SUBTREE –子树（当前路径的子目录）不再遍历了
SKIP_SIBLINGS –兄弟节点（同级别目录）不再访问了。
 */
public class FileVisitorTest extends SimpleFileVisitor<Path> {

    private void find(Path path){
        System.out.printf("访问-%s:%s%n",(Files.isDirectory(path)?"目录":"文件"),path.getFileName());
    }
    /*
    visitFile - 文件被访问时被调用。该文件的文件属性被传递给这个方法
     */
    @Override
    public FileVisitResult visitFile(Path file,BasicFileAttributes attrs){
        find(file);
        return FileVisitResult.CONTINUE;
    }

    /*
    preVisitDirectory - 一个路径被访问时调用
     */
    @Override
    public FileVisitResult preVisitDirectory(Path dir,BasicFileAttributes attrs){
        find(dir);
        return FileVisitResult.CONTINUE;
    }

    /*
     visitFileFailed - 当文件不能被访问时，此方法被调用。Exception被传递给这个方法。
  */
    @Override
    public FileVisitResult visitFileFailed(Path file,IOException e){
        System.out.println(e);
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) throws IOException{
        String dir = "/Users/wushang/Downloads/20151105";
        Files.walkFileTree(Paths.get( dir ), new FileVisitorTest());
    }
}