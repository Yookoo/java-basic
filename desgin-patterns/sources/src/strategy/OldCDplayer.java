package strategy;

/*
 * ��������ʽCD��
 */
public class OldCDplayer {

	public void playMusic(String singer){
		if(singer == "jay"){
			
			System.out.println("�����ܽ��������ݳ�");
			System.out.println("�໨��");
			System.out.println("˫�ع�");
			System.out.println("������");
			System.out.println("����ѩ");	
			
		}else if(singer == "li"){
			System.out.println("�������ٺ������ݳ�");
			System.out.println("ģ��");
			System.out.println("���");
			System.out.println("�ְ�����");	
		}else{
			System.out.println("û�иø���");
		}
	}
}
