package builder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test {

	public static void main(String[] args) throws Exception {

		ConnectionFactoryBuilder builder = new ConnectionFactoryBuilder();
		// ������ģʽ�ĺ���
		Connection connection = builder.build().openConnection();

		String sql = "select * from users;";
		PreparedStatement ps= connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			//��1��ʼ
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
		}
		ps.close();
		rs.close();
		connection.close();

	}

}
