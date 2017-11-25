package proxy;

public class Student implements Person {

	@Override
	public void study() throws Exception {
		System.out.println("我是学生,我要好好学习");
		throw new Exception("我抛出了一个异常");
	}

}
