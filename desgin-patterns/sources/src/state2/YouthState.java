package state2;

public class YouthState implements State {

	@Override
	public void live() {
		
		System.out.println("��������,�Ҷ�δ������ϣ��!");
	}

	@Override
	public State next() {
		// TODO Auto-generated method stub
		return new MiddleState();
	}

}
