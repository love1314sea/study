package avro;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;

import java.io.File;

/**
 * Created by wushang on 15/9/25.
 */
public class _1 {
    public static void main(String[] args) throws Exception {
        //生成schema
        Schema schema = new Schema.Parser().parse(new File("user.avsc"));
        //生成数据：GenericRecord
        GenericRecord user1 = new GenericData.Record(schema);
        user1.put("name", "zhang");
        user1.put("favorite_number", 256);
        GenericRecord user2 = new GenericData.Record(schema);
        user2.put("name", "bean");
        user2.put("favorite_number", 7);
        user2.put("favorite_color", "red");

        //把对象序列化到文件
        File file = new File("users.avro");
        DatumWriter<GenericRecord> datumWriter = new GenericDatumWriter<>(schema); //schema是必须的
        DataFileWriter<GenericRecord> dataFileWriter = new DataFileWriter<>(datumWriter);
        dataFileWriter.create(schema, file);
        dataFileWriter.append(user1);
        dataFileWriter.append(user2);
        dataFileWriter.close();

        //读取文件，并反序列化
        DatumReader<GenericRecord> datumReader = new GenericDatumReader<>(schema);
        DataFileReader<GenericRecord> dataFileReader = new DataFileReader<GenericRecord>(file, datumReader);
        GenericRecord user = null;
        while (dataFileReader.hasNext()) {
            user = dataFileReader.next();
            System.out.println(user);
        }
        dataFileReader.close();
    }

}
