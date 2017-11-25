package abstractfactory;

import simplefactory.Car;
import simplefactory.HandaCar;

public class HandaCarFactory implements CarFactory {

	@Override
	public Car getCar() {
		// TODO Auto-generated method stub
		return new HandaCar();
	}



}
