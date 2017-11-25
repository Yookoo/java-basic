package singleton;

public class Demo01 {

	/**
	 * 在主函数中调用Single创建的方法,并判断是否为同一对象;
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StarveSingle s1 = StarveSingle.getInstance();
		StarveSingle s2 = StarveSingle.getInstance();
		System.out.println(s1==s2);
		
		Config config = Config.getInstance();
		String name= config.getProperty("name");
		System.out.println("name="+name);
	}

}
