package proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {

	/**
	 * 通过jdk的Proxy动态代理生成对象
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Class<?>[] interfaces = new Class<?>[]{Singer.class,Student.class};
		//MyInvocationHandler handler = new MyInvocationHandler();
		Object obj = Proxy.newProxyInstance(Student.class.getClassLoader(), interfaces , new MyInvocationHandler());
		Singer singer = (Singer)obj;
		singer.sing("小苹果");
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
		// 将字符串转化为枚举类型
		MethodName methodName = MethodName.valueOf(method.getName().toUpperCase());
		
		switch (methodName) {
		case STUDY:
			System.out.println("我是苦逼的学生,天天学习,好好向上!");
			return null;
		case DOHOMEWORK:
			System.out.println("我是苦逼的学生,我一回家就有写不完的作业!");
			return null;
		case SING:
			System.out.println("我是苦逼的学生,我不会唱"+args[0]+",我只会唱让我们荡起双桨!");
			return null;
		case LIVES:
			System.out.println("作为一个苦逼的学生党,毫无幸福感可言!");
			return 0;
		}		
		return null;
	}
	
}

enum MethodName{
	STUDY,DOHOMEWORK,SING,LIVES;
}