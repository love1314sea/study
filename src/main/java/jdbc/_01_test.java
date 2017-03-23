package jdbc;


import java.sql.*;


/**
 * Created by wushang on 17/3/22.
 */
/*
使用 纯sun 提供的mysql-connector 访问数据库
 */
public class _01_test {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mytest","root","2015");
			System.out.println("connect--");
			PreparedStatement statement = connection.prepareStatement("select * from student_info where id = ?");
			statement.setInt(1, 1);
			ResultSet resultSet = statement.executeQuery();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
