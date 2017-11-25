package abstractfactory;

import simplefactory.BenzCar;
import simplefactory.Car;

public class BenzCarFactory implements CarFactory {

	@Override
	public Car getCar() {
		// TODO Auto-generated method stub
		return new BenzCar();
	}



	
}
