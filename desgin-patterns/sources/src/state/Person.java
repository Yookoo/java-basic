package state;

import java.util.HashMap;
import java.util.Map;

import singleton.Config;

public class Person {
	
	private Mood currentMood;
	
	private Map<String,Mood> moods = new HashMap<String, Mood>();
	
	//初始化普通心情
	public Person() {
		moods.put("default", new Normal());
	}

	public void setMood(String moodName,Mood mood) {	
		moods.put(moodName, mood);
	}

	public  void behavior(){
		currentMood = getMood();
		if(currentMood == null){
			currentMood = moods.get("default");
		}
		Mood currentMood_ = currentMood;
		currentMood_.behave();
	}
	
	
	public Mood getMood(){
		Config config = Config.getInstance();
		String moodName = config.getProperty("mood");		
		return moods.get(moodName);
		 
	 }
}
