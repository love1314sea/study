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
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;

		try {
			// 不需要加载并注册驱动
//			Class.forName("com.mysql.jdbc.Driver");
			//获取连接
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mytest?autoReconnect=true&useSSL=false", "root", "2015");

			statement = connection.prepareStatement("select * from student_info where id = ?");
			statement.setInt(1, 2);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String id = resultSet.getString("id");
				System.out.println("id=" + id);
			}

			statement = connection.prepareStatement("insert into student_info (id, name, phone,register_ts) values (?,?,?,?)");
			statement.setInt(1,2);
			statement.setString(2, "li");
			statement.setString(3, "13811229900");
			statement.setString(4, "2014-11-10 00:33:22");//数据库中 date类型
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
