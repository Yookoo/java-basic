package abstractfactory;

import simplefactory.Car;
import simplefactory.FordCar;

public class FordCarFactory implements CarFactory {

	@Override
	public Car getCar() {
		return new FordCar("blue");
	}
}
