package state2;

public class Person {
	
	private State state;
	
	
	public Person(State state) {
		super();
		this.state = state;
	}


	public void live(){
		
		if( state != null){
			state.live();
			state.next();
		}else{
			System.out.println("���Ѿ�����,û����һ��״̬��");
		}
	}
}
