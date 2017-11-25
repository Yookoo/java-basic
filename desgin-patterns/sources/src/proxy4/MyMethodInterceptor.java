package proxy4;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import singleton.Config;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MyMethodInterceptor implements MethodInterceptor {

	private Object object;
	private static Map<String, String> maps = new HashMap<String, String> ();

	public MyMethodInterceptor(Object object) {
		super();
		this.object = object;
	}
	
	{
				
		Config config = Config.getInstance();
		String proxyRules = config.getProperty("proxyRules");
		if(!(proxyRules==null)){
			String[] rules = proxyRules.split(",");
			for (String string : rules) {
				String[] rule = string.split(":");
				maps.put(rule[0], rule[1]);
		   }
	
		}
	}
	
	@Override
	public Object intercept(Object proxy, Method method, Object[] args,
			MethodProxy methodProxy) throws Throwable {

		String rulesKey = object.getClass().getName()+"-"+method.getName();
		
		if(!(maps == null || maps.isEmpty())){
			
			String value = maps.get(rulesKey);
			
			if(value == null||value.isEmpty()){
				
				value = maps.get(object.getClass().getName()+"-*");
				
				if(value == null||value.isEmpty()){
					return method.invoke(object, args);
				}
			}
				
			if("before".equals(value)){
				System.out.println("大家好！");
				return method.invoke(object, args);
			}
				
			if("after".equals(value)){
				Object pObject = method.invoke(object, args);
				System.out.println("谢谢大家！");
				return pObject;
			}	
		}	
		return method.invoke(object, args);
	}

}
