package builder;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;


import singleton.Config;

public class ConnectionFactoryBuilder {
	
	/**
	 * 利用建造者模式,模仿hibernate中的Sessionfactory建造一个ConnectionFactory用来创建jdbc连接;
	 * @return
	 * @throws Exception
	 */

	public ConnectionFactory build() throws Exception{
		
		Config config = Config.getInstance();
		Properties property = config.openProperty();
		
		DataSource dataSource = BasicDataSourceFactory.createDataSource(property);
		
		ConnectionFactory connectionFactory= new ConnectionFactory();
		connectionFactory.setDataSource(dataSource);
		return connectionFactory;
	}
	
	
	public static class ConnectionFactory {
		
		private DataSource dataSource;
		
		private ConnectionFactory() {
			super();
		}

		public void setDataSource(DataSource dataSource) {
			this.dataSource = dataSource;
		}
		
		
		public Connection openConnection() throws SQLException{		
			return dataSource.getConnection();	
		}

		public DataSource getDataSource() {
			return dataSource;
		}	
	}
}
