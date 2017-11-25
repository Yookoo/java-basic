package builder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test {

	public static void main(String[] args) throws Exception {

		ConnectionFactoryBuilder builder = new ConnectionFactoryBuilder();
		// 建造者模式的核心
		Connection connection = builder.build().openConnection();

		String sql = "select * from users;";
		PreparedStatement ps= connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			//从1开始
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
		}
		ps.close();
		rs.close();
		connection.close();

	}

}
