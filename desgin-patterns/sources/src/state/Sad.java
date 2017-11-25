package state;

public class Sad implements Mood {

	@Override
	public void behave() {
		System.out.println("今天心情很糟糕，没法活了！");
	}

}
