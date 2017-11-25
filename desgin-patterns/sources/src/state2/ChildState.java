package state2;

public class ChildState implements State {

	@Override
	public void live() {
		System.out.println("我是小孩,过着无忧无虑的童年生活!");
	}

	@Override
	public State next() {
		return new YouthState();
	}
}
