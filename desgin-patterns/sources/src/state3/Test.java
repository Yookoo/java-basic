package state3;

public class Test {

	public static void main(String[] args) {
		
		State state = State.CHILD;
		Person person = new Person(state);
		person.live();
		person.live();
		person.live();
		
	}
}
