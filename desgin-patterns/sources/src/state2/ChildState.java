package state2;

public class ChildState implements State {

	@Override
	public void live() {
		System.out.println("����С��,�����������ǵ�ͯ������!");
	}

	@Override
	public State next() {
		return new YouthState();
	}
}
