package proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test2 {


	public static void main(String[] args) {
		
		Class<?>[] interfaces = new Class<?>[]{Singer.class,Student.class};
		Object obj = Proxy.newProxyInstance(Student.class.getClassLoader(), interfaces , new JayInvocationHandler(new Jay()));
		Singer singer = (Singer)obj;
		singer.sing("������");
		int live = singer.lives();
		System.out.println("live="+live);
		
		Student student = (Student) obj;
		student.study();
		student.doHomework();
	}

}
class JayInvocationHandler implements InvocationHandler{

	private Jay jay;
	
	public JayInvocationHandler(Jay jay) {
		super();
		this.jay = jay;
	}


	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		//�˴����Զ���ʵ�������Ԥ����
		//�˴���ͨ���������,�൱��jay.method(args);
		Object obj = null;
		try {
			obj = method.invoke(jay, args);
		} catch (Exception e) {
			// �ڴ˿��Զ��׳����쳣���в�׽������
		}
		//�ڴ˴�����ͨ���������ִ��һЩ�ƺ���;
		return obj;
	}
	
}