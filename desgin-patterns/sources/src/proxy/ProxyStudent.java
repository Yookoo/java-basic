package proxy;

public class ProxyStudent implements Person {
	
	private Student student;

	@Override
	public void study()  {
		//�ڴ˴�����ͨ���������ִ��һЩԤ������;
		try {
			student.study();
		} catch (Exception e) {
			// �ڴ˿��Զ��׳����쳣���в�׽������
			e.printStackTrace();
		}
		//�ڴ˴�����ͨ���������ִ��һЩ�ƺ���;
	}

}
