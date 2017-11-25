package strategy;

public class NewCDplayer {
	
	private CD cd;

	public void setCd(CD cd) {
		this.cd = cd;
	}
	
	public void playMusic(){
		cd.sing();
	}
}
