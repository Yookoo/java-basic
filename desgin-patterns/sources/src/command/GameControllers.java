package command;


public class GameControllers {
	
//	private BtnA btnA;
//	private BtnB btnB;
//	private BtnC btnc;
//	private BtnD btnD;
	private Command[] command = new Command[4];
	
	public void setBtnA(Command command) {
		this.command[0] = command;
	}

	public void setBtnB(Command command) {
		this.command[1] = command;
	}

	public void setBtnC(Command command) {
		this.command[2] = command;
	}

	public void setBtnD(Command command) {
		this.command[3] = command;
	}

	public void pushA() {
		command[0].excute();
		
	}

	public void pushB() {
		command[1].excute();
		
	}
	public void pushC() {
		command[2].excute();
		
	}
	public void pushD() {
		command[3].excute();
		
	}

}
