package proxy;

public class ProxyStudent implements Person {
	
	private Student student;

	@Override
	public void study()  {
		//在此处可以通过代理对象执行一些预处理方法;
		try {
			student.study();
		} catch (Exception e) {
			// 在此可以对抛出的异常进行捕捉并处理
			e.printStackTrace();
		}
		//在此处可以通过代理对象执行一些善后工作;
	}

}
