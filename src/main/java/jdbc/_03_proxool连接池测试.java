package jdbc;


import org.logicalcobwebs.proxool.ProxoolException;
import org.logicalcobwebs.proxool.ProxoolFacade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by wushang on 2017/3/24.
 */

/*
使用代码的方式
 */
public class _03_proxool连接池测试 {

	private static Properties properties = new Properties();

	static {
		try {
			Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
			properties.setProperty("proxool.maximum-connection-count", "10");
			properties.setProperty("proxool.house-keeping-test-sql", "select CURRENT_DATE");
			properties.setProperty("user", "root");
			properties.setProperty("password", "2015");
			String alias = "example";
			String driverClass = "com.mysql.jdbc.Driver";
			String driverUrl = "jdbc:mysql://127.0.0.1:3306/mytest?autoReconnect=true&useSSL=false";
			String url = "proxool." + alias + ":" + driverClass + ":" + driverUrl;
			ProxoolFacade.registerConnectionPool(url, properties); //注册
		} catch (ProxoolException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}


	public void test() {
		try {
			Connection connection = DriverManager.getConnection("proxool.example");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new _03_proxool连接池测试().test();

	}
}
