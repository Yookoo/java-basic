package factorymethod;

import simplefactory.Car;

public abstract class I4S {

	public Car sellCar(){
		return getCar();
	};
	
	public abstract Car getCar();
}
