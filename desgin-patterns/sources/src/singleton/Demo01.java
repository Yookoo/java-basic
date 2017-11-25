package singleton;

public class Demo01 {

	/**
	 * ���������е���Single�����ķ���,���ж��Ƿ�Ϊͬһ����;
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
