package proxy4;

import net.sf.cglib.proxy.Enhancer;

public class ProxyBuilder {
	
	private Enhancer enhancer = new Enhancer();
	
	public ProxyBuilder setProxy(Object object){
		enhancer.setSuperclass(object.getClass());
		enhancer.setCallback(new MyMethodInterceptor(object));
		return this;
	}
	
	public Object build(){	
		return enhancer.create();
		
	}
}
