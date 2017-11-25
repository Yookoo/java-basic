package decorator;

public class Woman {
	
	private String name;
	
	private int beauty;
	
	private int iq;
	

	public Woman(String name, int beauty, int iq) {
		super();
		this.name = name;
		this.beauty = beauty;
		this.iq = iq;
	}

	public String getName() {
		return name;
	}

	public int getBeauty() {
		return beauty;
	}

	public int getIq() {
		return iq;
	}

	public void say(){
		System.out.println("Œ“Ω–"+name);
	}
	
}
