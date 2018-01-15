package builder;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import singleton.Config;

public class ConnectionFactoryBuilder {
	
	/**
	 * ���ý�����ģʽ,ģ��hibernate�е�Sessionfactory����һ��ConnectionFactory��������jdbc����;
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
