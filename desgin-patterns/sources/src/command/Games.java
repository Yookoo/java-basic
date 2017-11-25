package command;

public class Games {

	
	public static void main(String[] args) {
		
		GameControllers controllers = new GameControllers(); 
		Command attackCommand = new AttackCommand();
		Command spellCommand = new SpellCommand();
		Command propsCommand = new PropsCommand();
		Command fleeCommand = new FleeCommand();
		controllers.setBtnA(attackCommand);
		controllers.setBtnB(fleeCommand);
		controllers.setBtnC(propsCommand);
		controllers.setBtnD(spellCommand);
		controllers.pushA();
		controllers.pushB();
		controllers.pushC();
		controllers.pushD();
		

	}

}
