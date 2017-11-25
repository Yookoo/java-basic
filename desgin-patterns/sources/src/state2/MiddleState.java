package state2;

public class MiddleState implements State {

	@Override
	public void live() {
		
		System.out.println("我是中年人,我要为全家人而努力打拼!!");
	}

	@Override
	public State next() {
		// TODO Auto-generated method stub
		return new EldState();
	}

}
