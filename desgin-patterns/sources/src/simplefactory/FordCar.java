package simplefactory;

public class FordCar implements Car {
	
	private String color;
	
	public FordCar(String color){
		this.color = color;
	}
	@Override
	public void run() {
		System.out.println("���Ǹ��ؽγ�.��˿ר��!");
	}

}
