package proxy2;

public class Jay implements Singer,Student{

	@Override
	public void study() {
		System.out.println("��Ϊһ����������,��Ӧ����ʱ���,Ŭ��ѧϰ!!");
	}

	@Override
	public void doHomework() {
		System.out.println("�Ҷ��Ǵ�����Ϊë��Ҫд��ҵ��??�ӵ���!!");
	}

	@Override
	public int lives() {
		System.out.println("���������û��û�����Ҹ�����");
		return 100;
	}

	@Override
	public void sing(String name) {
		if(name.equals("˫�ع�")){
			System.out.println("�ߺ߹���,��ʹ��˫�ع�");
		}else if(name.equals("������")){
			System.out.println("�������ȸ�ڵ��߸��϶���.");
		}else{
			System.out.println("�Ҳ��ᳪ��");
		}
		
	}

}
