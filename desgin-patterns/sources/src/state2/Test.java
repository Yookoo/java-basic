package state2;

public class Test {

	public static void main(String[] args) {
		
		State state = new ChildState();
		Person person = new Person(state);
		person.live();
		person.live();
		person.live();
		
	}
}
