package proxy;

public class Student implements Person {

	@Override
	public void study() throws Exception {
		System.out.println("����ѧ��,��Ҫ�ú�ѧϰ");
		throw new Exception("���׳���һ���쳣");
	}

}
