package spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wushang on 17/3/5.
 */
public class _01_JdbcTest {
//	private JdbcTemplate jdbcTemplate;

	//执行INSERT UPDATE DELETE
	public  void testUpdate() {
		String sql = "update employees set last_name = ? where id = ?";
//		jdbcTemplate.update(sql, "Jack", 1);

	}

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-jdbc.xml");
//		JdbcTemplate template = (JdbcTemplate) ctx.getBean("");


	}
}
