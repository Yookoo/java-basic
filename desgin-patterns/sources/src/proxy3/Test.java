package proxy3;


import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer; 
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class Test {

	
	public static void main(String[] args) {
		final Jay jay = new Jay();
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(Jay.class);
		//�����ڲ���;
		enhancer.setCallback(new MethodInterceptor(){

			@Override
			public Object intercept(Object proxy, Method method, Object[] args,
					MethodProxy methodProxy) throws Throwable {
				System.out.println("------------����ִ��ǰ----------");
				//Object object = methodProxy.invokeSuper(proxy, args); 
				Object object = method.invoke(jay, args);
				System.out.println("------------����ִ�к�----------");
				return object;
			}});
		Jay jayproxy = (Jay)enhancer.create();
		jayproxy.study();
		jayproxy.doHomework();
		jayproxy.lives();
		jayproxy.sing("������");
	}

}