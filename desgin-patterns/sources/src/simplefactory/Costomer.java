package simplefactory;

public class Costomer {

	private Car car;
	
	public void setCar(Car car) {
		this.car = car;
	}

	public void drive() {
		car.run();
	}
}
