package gson.顺序打印;

/**
 * Created by wushang on 16/12/2.
 */
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JacksonStreamExample {
	public static void main(String[] args) {

		try {

			StringWriter writer=new StringWriter();

			JsonFactory jfactory = new JsonFactory();

			/*** write to file ***/
			JsonGenerator jGenerator = jfactory.createJsonGenerator(writer);
			jGenerator.writeStartObject(); // {

			jGenerator.writeStringField("name", "mkyong"); // "name" : "mkyong"
			jGenerator.writeNumberField("age", 29); // "age" : 29

			jGenerator.writeFieldName("messages"); // "messages" :
			jGenerator.writeStartArray(); // [

			jGenerator.writeString("msg 1"); // "msg 1"
			jGenerator.writeString("msg 2"); // "msg 2"
			jGenerator.writeString("msg 3"); // "msg 3"

			jGenerator.writeEndArray(); // ]

			Student student = new Student();
			student.setName("zhang");
			student.setAge(19);

			List<String> list = new ArrayList<>();
			list.add("li");
			list.add("huang");
			student.setFriends(list);
			Map<String, Object> map = new HashMap<>();
			map.put("teacher2", "yuwen2");
			map.put("teacher1", "shuxu");

			map.put("teacher3", "yuwen3");
			map.put("teacher4", "yuwen4");

//			student.setOthers(map);
			jGenerator.setCodec(new ObjectMapper());
			jGenerator.writeObjectField("ss", map);
//			jGenerator.writeObject(student);
//			jGenerator.writeStringField("ss",student.toString());

			jGenerator.writeEndObject(); // }
			jGenerator.flush();

			jGenerator.close();
			writer.close();
			writer.getBuffer();
			System.out.println(writer.toString());

		} catch (JsonGenerationException e) {

			e.printStackTrace();

		} catch (JsonMappingException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}