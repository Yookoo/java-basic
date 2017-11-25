package simplefactory2;

public class HairFactory {

	
	@SuppressWarnings("static-access")
	public Hair getHair(String className){
		Hair hair = null ;
		try {
			hair = (Hair) getClass().forName(className).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hair;		
	}
}
