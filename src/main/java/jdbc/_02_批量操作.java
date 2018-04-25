package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wushang on 2017/3/24.
 */
public class _02_批量操作 {
	public static void main(String[] args) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;

		try {

//			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mytest?autoReconnect=true&useSSL=false", "root", "2015");
			statement = connection.prepareStatement("insert into student_info (id, name, phone,register_ts) values (?,?,?,?)");
			List<Student> list = new ArrayList<>();
			list.add(new Student(3,"liubei","13910224455", "1922-2-12 1:2:3"));
			list.add(new Student(4,"guanyu","13120224466", "1933-3-13 1:2:3"));
			list.add(new Student(5,"zhangfei","13120224477", "1944-4-23 1:2:3"));

			connection.setAutoCommit(false);//禁用自动提交
			for(Student student : list) {
				statement.setInt(1, student.id);
				statement.setString(2, student.name);
				statement.setString(3, student.phone);
				statement.setString(4, student.registerTs);
				statement.addBatch();//批量
			}
			int[] i = statement.executeBatch();//批量
			connection.commit();//提交
			connection.setAutoCommit(true);//恢复



//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

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

class Student {
	public int id;
	public String name;
	public String phone;
	public String registerTs;
	public Student(int id, String name, String phone, String registerTs){
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.registerTs = registerTs;
	}
}

