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
		// ��һ��:��������
		Class.forName("com.mysql.jdbc.Driver");

		// �ڶ���:�������ݿ�����
		String url = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8";
		String user = "root";
		String password = "root";
		Connection connection = DriverManager.getConnection(url, user, password);

		// ������:Ԥ����SQL
		String sql = "select gradeid,gradename from grade";
		PreparedStatement ps = connection.prepareStatement(sql);

		// ���Ĳ�:ִ��SQL
		ResultSet resultSet = ps.executeQuery();

		// ���岽:������
		while (resultSet.next()) {
			int gradeid = resultSet.getInt("gradeid");
			String gradename = resultSet.getString("gradename");

			System.out.println(gradeid + " " + gradename);
		}

		// ������:�ͷ���Դ
		resultSet.close();
		ps.close();
		connection.close();
	}
	public void create() throws Exception {
		// ��һ��:��������
		Class.forName("com.mysql.jdbc.Driver");

		// �ڶ���:�������ݿ�����
		String url = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8";
		String user = "root";
		String password = "root";
		Connection connection = DriverManager.getConnection(url, user, password);

		// ������:Ԥ����SQL
		String sql = "insert into grade(gradeid,gradename)values(?,?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setInt(1, 20);
		ps.setString(2,"java4");

		// ���Ĳ�:ִ��SQL
		int row= ps.executeUpdate();

		// ���岽:������
		System.out.println(row>0?"��ӳɹ�":"���ʧ��");

		// ������:�ͷ���Դ
		ps.close();
		connection.close();
	}
	
	public void update() throws Exception {
		// ��һ��:��������
		Class.forName("com.mysql.jdbc.Driver");

		// �ڶ���:�������ݿ�����
		String url = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8";
		String user = "root";
		String password = "root";
		Connection connection = DriverManager.getConnection(url, user, password);

		// ������:Ԥ����SQL
		String sql = "update grade set gradename=? where gradeid=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1,"java5");
		ps.setInt(2, 20);

		// ���Ĳ�:ִ��SQL
		int row= ps.executeUpdate();

		// ���岽:������
		System.out.println(row>0?"�޸ĳɹ�":"�޸�ʧ��");

		// ������:�ͷ���Դ
		ps.close();
		connection.close();
	}
	public void delete() throws Exception {
		// ��һ��:��������
		Class.forName("com.mysql.jdbc.Driver");

		// �ڶ���:�������ݿ�����
		String url = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8";
		String user = "root";
		String password = "root";
		Connection connection = DriverManager.getConnection(url, user, password);

		// ������:Ԥ����SQL
		String sql = "delete from grade where gradeid=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, 20);

		// ���Ĳ�:ִ��SQL
		int row= ps.executeUpdate();

		// ���岽:������
		System.out.println(row>0?"ɾ���ɹ�":"ɾ��ʧ��");

		// ������:�ͷ���Դ
		ps.close();
		connection.close();
	}
}
