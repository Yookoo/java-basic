package proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test2 {


	public static void main(String[] args) {
		
		Class<?>[] interfaces = new Class<?>[]{Singer.class,Student.class};
		Object obj = Proxy.newProxyInstance(Student.class.getClassLoader(), interfaces , new JayInvocationHandler(new Jay()));
		Singer singer = (Singer)obj;
		singer.sing("七里香");
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
		//此处可以对真实对象进行预处理
		//此处是通过反射调用,相当于jay.method(args);
		Object obj = null;
		try {
			obj = method.invoke(jay, args);
		} catch (Exception e) {
			// 在此可以对抛出的异常进行捕捉并处理
		}
		//在此处可以通过代理对象执行一些善后工作;
		return obj;
	}
	
}