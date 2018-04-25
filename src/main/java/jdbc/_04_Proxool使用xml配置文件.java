package jdbc;

import org.logicalcobwebs.proxool.ProxoolException;
import org.logicalcobwebs.proxool.configuration.JAXPConfigurator;

import java.sql.*;

/**
 * Created by wushang on 2017/3/24.
 */

/*
使用xml配置文件方式
 */
public class _04_Proxool使用xml配置文件 {

	static {
		try {
			JAXPConfigurator.configure("/Users/wushang/IdeaProjects/toyprogram/study/src/main/resources/proxool.xml", false);
//			JAXPConfigurator.configure("../proxool.xml", false);//不知道为什么,配置绝对路径找不到文件
		} catch (ProxoolException e) {
			e.printStackTrace();
		}
	}

	public void run() {

		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;

		try {
			connection = DriverManager.getConnection("proxool.wushangtest");
			statement = connection.prepareStatement("select * from student_info where id = ?");
			statement.setInt(1, 2);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String id = resultSet.getString("id");
				System.out.println("id=" + id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		new _04_Proxool使用xml配置文件().run();

	}
}
