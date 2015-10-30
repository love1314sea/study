package IO;

import java.io.File;
import java.io.FilenameFilter;

public class _01_FilenameFilter {
   public static void main(String[] args ) {
       File file = new File("D:\\vmware");
       String[] names = file.list(new FilenameFilter() { //使用匿名内部类
           @Override
           public boolean accept(File dir, String name) {
               if(name.endsWith("ter")) {
                   return true;
               }
               return false;
           }
       });
       for(String name : names) {
           System.out.println(name);
       }
   }
}
