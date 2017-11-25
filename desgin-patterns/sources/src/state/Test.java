package state;

public class Test {
	
	public static void main(String[] args) {
				
		Person person = new Person();
		person.setMood("happy", new Happy());
		person.setMood("normal", new Normal());
		person.setMood("sad", new Sad());
		person.behavior();
	}

}
