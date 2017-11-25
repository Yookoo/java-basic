package state;

public class Happy implements Mood {

	@Override
	public void behave() {
		System.out.println("今天心情很开心，我们一起出去玩吧！");
	}

}
