package factorymethod;

import abstractfactory.HandaCarFactory;
import simplefactory.Car;

public class HandaCar4S extends I4S {
	
	private HandaCarFactory handaCarFactory;
	
	@Override
	public Car getCar() {
		return handaCarFactory.getCar();
	}
}
