package simplefactory2;



public class Demo02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HairFactory factory = new HairFactory();
		Hair hair = factory.getHair("FactoryMode.LeftHair");
		hair.drawHair();
	}

}
