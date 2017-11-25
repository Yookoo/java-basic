package state2;

public class YouthState implements State {

	@Override
	public void live() {
		
		System.out.println("我是青年,我对未来充满希望!");
	}

	@Override
	public State next() {
		// TODO Auto-generated method stub
		return new MiddleState();
	}

}
