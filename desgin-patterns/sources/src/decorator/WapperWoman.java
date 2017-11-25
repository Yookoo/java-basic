package decorator;

public abstract class WapperWoman extends Woman {
	
	/***
	 * װ����ģʽ�ĺ�������
	 * WapperWoman���б�װ���� Woman�������;
	 * ͨ�����ַ���,���Խ���װ�����������Ϊ����������һ����װ������ٴΰ�װ.
	 * ͨ�����ַ���ʵ�ֶ�ĳ������ж�ΰ�װ.
	 */

	private Woman woman;
	
	public WapperWoman(Woman woman) {
		super(woman.getName(), woman.getBeauty(), woman.getIq());
		this.woman = woman;
	}
	@Override
	public String getName() {
		return woman.getName();
	}

	public int getBeauty() {
		return woman.getBeauty();
	}

	public int getIq() {
		return woman.getIq();
	}

	public void say(){
		System.out.println("�ҽ�"+woman.getName());
	}
	
	
}
