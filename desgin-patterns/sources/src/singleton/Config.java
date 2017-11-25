package singleton;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class Config {

	/**
	 * 单例模式实例:
	 * 一个properties配置文件在一个项目中只能加载一次,
	 * 但是jdk为我们提供的property对象并不是单例的,如果配置文件需要用到多次,很容易造成多次创建的情况.
	 * 这里我们的解决方法是:写一个Config类是单例的,并对property进行封装
	 * 
	 */
	private Properties properties;

	private static Config config = new Config();
	
	//1.私有化构造方法;
	private Config(){
		properties =new Properties();
		try {
			//properties.load(new FileInputStream(new File("src/singleton/config.properties")));
			properties.load(this.getClass().getClassLoader().getResourceAsStream("config.properties"));
			//System.out.println("执行了Config的构造方法");
		} catch (Exception e) {
			e.printStackTrace();
			//throw new RuntimeException();
		}
	}
	
	//2.创建共有的getInstance()方法
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
