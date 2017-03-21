package gson.顺序打印;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;

import java.io.*;
import java.util.*;

/**
 * Created by wushang on 16/12/2.
 */
public class _1 {

	public static void main(String[] args) {

		Student student = new Student();
		student.setAge(19);
		student.setName("zhang");
		List<String> list = new ArrayList<>();
		list.add("li");
		list.add("huang");
		student.setFriends(list);
		Map<String, Object> map = new HashMap<>();
		map.put("teacher2", "yuwen2");
		map.put("teacher1", "shuxu");

		map.put("teacher3", "yuwen3");
		map.put("teacher4", "yuwen4");

		student.setOthers(map);


		Map<String, Object> linked2 = new LinkedHashMap<String, Object>();
		linked2.put("b", "2");
		linked2.put("a", "1");
		linked2.put("c", student.toString());
		linked2.put("e", new String[]{"a1", "a2", "a4"});
		Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
		String jsonStr = gson.toJson(linked2);
		System.out.println(jsonStr);
	}

}

class Student implements Serializable {
	private int age;
	private String name;
	private List<String> friends;
	private Map<String, Object> others;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getFriends() {
		return friends;
	}

	public void setFriends(List<String> friends) {
		this.friends = friends;
	}

	public Map<String, Object> getOthers() {
		return others;
	}

	public void setOthers(Map<String, Object> others) {
		this.others = others;
	}

	//	@Override
	public String toString() {
//		Map<String, Object> linked2 = new LinkedHashMap<String, Object>();
//		linked2.put("age", age);
//		linked2.put("name", name);
//		linked2.put("friends", friends);
//		linked2.put("others", others);
//		Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
//		String jsonStr = gson.toJson(linked2);
//		System.out.println(jsonStr);
//		return jsonStr;
		JsonFactory jfactory = new JsonFactory();
		StringWriter sw = new StringWriter();

		try {

			JsonGenerator jGenerator = jfactory.createJsonGenerator(sw);
			jGenerator.writeStartObject(); // {
			jGenerator.writeNumberField("age", this.age);
			jGenerator.writeStringField("name", this.name);

			jGenerator.writeEndObject(); // }

			jGenerator.flush();


		} catch (IOException e) {
			e.printStackTrace();
		}
		return sw.toString();
	}

}