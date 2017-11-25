package proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {

	/**
	 * ͨ��jdk��Proxy��̬�������ɶ���
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Class<?>[] interfaces = new Class<?>[]{Singer.class,Student.class};
		//MyInvocationHandler handler = new MyInvocationHandler();
		Object obj = Proxy.newProxyInstance(Student.class.getClassLoader(), interfaces , new MyInvocationHandler());
		Singer singer = (Singer)obj;
		singer.sing("Сƻ��");
		int live = singer.lives();
		System.out.println("live="+live);
		
		Student student = (Student) obj;
		student.study();
		student.doHomework();
	}
}


class MyInvocationHandler implements InvocationHandler{

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// ���ַ���ת��Ϊö������
		MethodName methodName = MethodName.valueOf(method.getName().toUpperCase());
		
		switch (methodName) {
		case STUDY:
			System.out.println("���ǿ�Ƶ�ѧ��,����ѧϰ,�ú�����!");
			return null;
		case DOHOMEWORK:
			System.out.println("���ǿ�Ƶ�ѧ��,��һ�ؼҾ���д�������ҵ!");
			return null;
		case SING:
			System.out.println("���ǿ�Ƶ�ѧ��,�Ҳ��ᳪ"+args[0]+",��ֻ�ᳪ�����ǵ���˫��!");
			return null;
		case LIVES:
			System.out.println("��Ϊһ����Ƶ�ѧ����,�����Ҹ��п���!");
			return 0;
		}		
		return null;
	}
	
}

enum MethodName{
	STUDY,DOHOMEWORK,SING,LIVES;
}