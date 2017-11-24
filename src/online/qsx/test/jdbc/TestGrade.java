package online.qsx.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestGrade {
	public static void main(String[] args) throws Exception {
		new TestGrade().delete();
	}
	public void reade() throws Exception {
		// 第一步:导入驱动
		Class.forName("com.mysql.jdbc.Driver");

		// 第二步:构建数据库连接
		String url = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8";
		String user = "root";
		String password = "root";
		Connection connection = DriverManager.getConnection(url, user, password);

		// 第三步:预编译SQL
		String sql = "select gradeid,gradename from grade";
		PreparedStatement ps = connection.prepareStatement(sql);

		// 第四步:执行SQL
		ResultSet resultSet = ps.executeQuery();

		// 第五步:处理结果
		while (resultSet.next()) {
			int gradeid = resultSet.getInt("gradeid");
			String gradename = resultSet.getString("gradename");

			System.out.println(gradeid + " " + gradename);
		}

		// 第六步:释放资源
		resultSet.close();
		ps.close();
		connection.close();
	}
	public void create() throws Exception {
		// 第一步:导入驱动
		Class.forName("com.mysql.jdbc.Driver");

		// 第二步:构建数据库连接
		String url = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8";
		String user = "root";
		String password = "root";
		Connection connection = DriverManager.getConnection(url, user, password);

		// 第三步:预编译SQL
		String sql = "insert into grade(gradeid,gradename)values(?,?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setInt(1, 20);
		ps.setString(2,"java4");

		// 第四步:执行SQL
		int row= ps.executeUpdate();

		// 第五步:处理结果
		System.out.println(row>0?"添加成功":"添加失败");

		// 第六步:释放资源
		ps.close();
		connection.close();
	}
	
	public void update() throws Exception {
		// 第一步:导入驱动
		Class.forName("com.mysql.jdbc.Driver");

		// 第二步:构建数据库连接
		String url = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8";
		String user = "root";
		String password = "root";
		Connection connection = DriverManager.getConnection(url, user, password);

		// 第三步:预编译SQL
		String sql = "update grade set gradename=? where gradeid=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1,"java5");
		ps.setInt(2, 20);

		// 第四步:执行SQL
		int row= ps.executeUpdate();

		// 第五步:处理结果
		System.out.println(row>0?"修改成功":"修改失败");

		// 第六步:释放资源
		ps.close();
		connection.close();
	}
	public void delete() throws Exception {
		// 第一步:导入驱动
		Class.forName("com.mysql.jdbc.Driver");

		// 第二步:构建数据库连接
		String url = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8";
		String user = "root";
		String password = "root";
		Connection connection = DriverManager.getConnection(url, user, password);

		// 第三步:预编译SQL
		String sql = "delete from grade where gradeid=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, 20);

		// 第四步:执行SQL
		int row= ps.executeUpdate();

		// 第五步:处理结果
		System.out.println(row>0?"删除成功":"删除失败");

		// 第六步:释放资源
		ps.close();
		connection.close();
	}
}
