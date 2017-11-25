package simplefactory;

import singleton.Config;

public class CarFactory {
	/**
	 * 简单工厂模式
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */

	/*public Car getCar(String carName) {
		
		if(carName == "ford"){
			return new FordCar();
		}else if(carName == "handa"){
			return new HandaCar();
		}else if(carName == "benz"){
			return new BenzCar();
		}else{
			return null;
		}		
	}*/
	public static Car getCar() throws Exception{
		Config config =  Config.getInstance();
		String carName = config.getProperty("car");
		return (Car) Class.forName(carName).newInstance();
	}
}
