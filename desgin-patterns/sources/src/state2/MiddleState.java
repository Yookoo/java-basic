package state2;

public class MiddleState implements State {

	@Override
	public void live() {
		
		System.out.println("����������,��ҪΪȫ���˶�Ŭ����ƴ!!");
	}

	@Override
	public State next() {
		// TODO Auto-generated method stub
		return new EldState();
	}

}
