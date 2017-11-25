package state;

public class Normal implements Mood{

	@Override
	public void behave() {
		System.out.println("今天心情一般，在家不出去了！");
	}

}
