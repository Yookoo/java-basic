package singleton;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class Config {

	/**
	 * ����ģʽʵ��:
	 * һ��properties�����ļ���һ����Ŀ��ֻ�ܼ���һ��,
	 * ����jdkΪ�����ṩ��property���󲢲��ǵ�����,��������ļ���Ҫ�õ����,��������ɶ�δ��������.
	 * �������ǵĽ��������:дһ��Config���ǵ�����,����property���з�װ
	 * 
	 */
	private Properties properties;

	private static Config config = new Config();
	
	//1.˽�л����췽��;
	private Config(){
		properties =new Properties();
		try {
			//properties.load(new FileInputStream(new File("src/singleton/config.properties")));
			properties.load(this.getClass().getClassLoader().getResourceAsStream("config.properties"));
			//System.out.println("ִ����Config�Ĺ��췽��");
		} catch (Exception e) {
			e.printStackTrace();
			//throw new RuntimeException();
		}
	}
	
	//2.�������е�getInstance()����
	public static Config getInstance(){
		return config;
	} 
	
	
	public String getProperty(String key){
		return properties.getProperty(key);
	}
	public Properties openProperty(){
		return properties;
	}
}
