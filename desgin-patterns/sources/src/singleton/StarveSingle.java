package singleton;
/**
 * ����ģʽģ�壺����ʽ
 * @author ZHU
 * ��ͼ����֤һ�������һ��ʵ�������ṩһ����������ȫ�ַ��ʵ㡣
 * ��Ҫ�����һ��ȫ��ʹ�õ���Ƶ���ش��������١�
 * ��ʱʹ�ã����������ʵ����Ŀ����ʡϵͳ��Դ��ʱ��
 * ��ν�����ж�ϵͳ�Ƿ��Ѿ������������������򷵻أ����û���򴴽���
 * �ؼ����룺���캯����˽�еġ�
 * Ӧ��ʵ���� 1��һ����ֻ����һ����ϯ�� 2��Windows �Ƕ���̶��̵߳ģ��ڲ���һ���ļ���ʱ�򣬾Ͳ��ɱ���س��ֶ�����̻��߳�ͬʱ����һ���ļ����������������ļ��Ĵ������ͨ��Ψһ��ʵ�������С� 3��һЩ�豸�������������Ϊ����ģʽ������һ����������̨��ӡ�����������ʱ���Ҫ��������̨��ӡ����ӡͬһ���ļ���
 * �ŵ㣺 1�����ڴ���ֻ��һ��ʵ�����������ڴ�Ŀ�����������Ƶ���Ĵ���������ʵ�����������ѧԺ��ҳҳ�滺�棩�� 2���������Դ�Ķ���ռ�ã�����д�ļ���������
 * ȱ�㣺û�нӿڣ����ܼ̳У��뵥һְ��ԭ���ͻ��һ����Ӧ��ֻ�����ڲ��߼�����������������ô����ʵ������
 * ʹ�ó����� 1��Ҫ������Ψһ���кš� 2��WEB �еļ�����������ÿ��ˢ�¶������ݿ����һ�Σ��õ����Ȼ��������� 3��������һ��������Ҫ���ĵ���Դ���࣬���� I/O �����ݿ�����ӵȡ�
 * ע�����getInstance() ��������Ҫʹ��ͬ���� synchronized (Singleton.class) ��ֹ���߳�ͬʱ������� instance �����ʵ������
 */

public class StarveSingle {
	/*
	 * 1.Ҫ��֤����ģʽ,���ȱ��뽫���캯��˽�л�,������ͨ��new����������;
	 * 2.Ȼ��ͨ��һ�����еķ�������һ��ʵ������;
	 * 3.��Ϊ�����޷�����,���������Ҫ���ø÷���,���뽲�÷�������Ϊ��̬��(static),�����贴�����󼴿ɵ���;
	 */
	private StarveSingle(){}
	
	private static StarveSingle single = new StarveSingle();
	
	public static StarveSingle getInstance() {
		return single;
	}

}
/**
 * ����ģʽģ�壺����ʽ����ͬ����(��֧�ֶ��߳�)
 * @author ZHU
 *
 */

class LazySingle01{
	
	private LazySingle01(){}
	
	private static LazySingle01 single ;
	
	public static LazySingle01 getInstance() {
		if(single == null)
		{
			single = new LazySingle01() ;
		}
		return single;
	}
}
/**
 * ����ģʽģ�壺����ʽ��ͬ����(֧�ֶ��߳�,����Ӱ��Ч��)
 * @author ZHU
 *
 */

class LazySingle02{
	
	private LazySingle02(){}
	
	private static LazySingle02 single ;
	
	public static synchronized LazySingle02 getInstance() {
		if(single == null)
		{
			single = new LazySingle02() ;
		}
		return single;
	}
}
