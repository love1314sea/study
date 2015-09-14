package guava._03_Multimap;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * Created by wushang on 15/7/11.
 */
public class _02_test {
    public void teststuScoreMultimap(){
        Multimap<String,StudentScore> scoreMultimap = ArrayListMultimap.create();
        for(int i=10;i<25;i++){
            StudentScore studentScore=new StudentScore();
            studentScore.CourseId=1001+i;
            studentScore.score=100-i;
            scoreMultimap.put("peida",studentScore);
        }

        for(int i=10;i<25;i++){
            StudentScore studentScore=new StudentScore();
            studentScore.CourseId=1001+i;
            studentScore.score=100-i;
            scoreMultimap.put("ggg",studentScore);
        }
        System.out.println("scoreMultimap:"+scoreMultimap.size());

        System.out.println("scoreMultimap:"+scoreMultimap.keys().size());
    }

    public static void main(String[] args) {
        new _02_test().teststuScoreMultimap();
    }
}
