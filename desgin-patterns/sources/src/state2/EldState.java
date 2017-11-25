package state2;

public class EldState implements State {

	@Override
	public void live() {

		System.out.println("我是老年人,我要安享晚年!");

	}

	@Override
	public State next() {
		// TODO Auto-generated method stub
		return null;
	}

}
