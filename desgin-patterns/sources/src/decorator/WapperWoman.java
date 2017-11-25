package decorator;

public abstract class WapperWoman extends Woman {
	
	/***
	 * 装饰者模式的核心内容
	 * WapperWoman持有被装饰者 Woman的类对象;
	 * 通过这种方法,可以将包装过的类对象作为参数传给下一个包装类进行再次包装.
	 * 通过这种方法实现对某个类进行多次包装.
	 */

	private Woman woman;
	
	public WapperWoman(Woman woman) {
		super(woman.getName(), woman.getBeauty(), woman.getIq());
		this.woman = woman;
	}
	@Override
	public String getName() {
		return woman.getName();
	}

	public int getBeauty() {
		return woman.getBeauty();
	}

	public int getIq() {
		return woman.getIq();
	}

	public void say(){
		System.out.println("我叫"+woman.getName());
	}
	
	
}
