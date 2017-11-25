package simplefactory;

public class Test {

	public static void main(String[] args) throws Exception {
		Costomer c = new Costomer();
		c.setCar(CarFactory.getCar());
		c.drive();
	}
}
