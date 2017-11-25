package singleton;
/**
 * 单例模式模板：饿汉式
 * @author ZHU
 * 意图：保证一个类仅有一个实例，并提供一个访问它的全局访问点。
 * 主要解决：一个全局使用的类频繁地创建与销毁。
 * 何时使用：当您想控制实例数目，节省系统资源的时候。
 * 如何解决：判断系统是否已经有这个单例，如果有则返回，如果没有则创建。
 * 关键代码：构造函数是私有的。
 * 应用实例： 1、一个党只能有一个主席。 2、Windows 是多进程多线程的，在操作一个文件的时候，就不可避免地出现多个进程或线程同时操作一个文件的现象，所以所有文件的处理必须通过唯一的实例来进行。 3、一些设备管理器常常设计为单例模式，比如一个电脑有两台打印机，在输出的时候就要处理不能两台打印机打印同一个文件。
 * 优点： 1、在内存里只有一个实例，减少了内存的开销，尤其是频繁的创建和销毁实例（比如管理学院首页页面缓存）。 2、避免对资源的多重占用（比如写文件操作）。
 * 缺点：没有接口，不能继承，与单一职责原则冲突，一个类应该只关心内部逻辑，而不关心外面怎么样来实例化。
 * 使用场景： 1、要求生产唯一序列号。 2、WEB 中的计数器，不用每次刷新都在数据库里加一次，用单例先缓存起来。 3、创建的一个对象需要消耗的资源过多，比如 I/O 与数据库的连接等。
 * 注意事项：getInstance() 方法中需要使用同步锁 synchronized (Singleton.class) 防止多线程同时进入造成 instance 被多次实例化。
 */

public class StarveSingle {
	/*
	 * 1.要保证单例模式,首先必须将构造函数私有化,不允许通过new来创建对象;
	 * 2.然后通过一个公有的方法返回一个实例对象;
	 * 3.因为对象无法创建,所以如果想要调用该方法,必须讲该方法声明为静态的(static),即无需创建对象即可调用;
	 */
	private StarveSingle(){}
	
	private static StarveSingle single = new StarveSingle();
	
	public static StarveSingle getInstance() {
		return single;
	}

}
/**
 * 单例模式模板：懒汉式不带同步锁(不支持多线程)
 * @author ZHU
 *
 */

class LazySingle01{
	
	private LazySingle01(){}
	
	private static LazySingle01 single ;
	
	public static LazySingle01 getInstance() {
		if(single == null)
		{
			single = new LazySingle01() ;
		}
		return single;
	}
}
/**
 * 单例模式模板：懒汉式带同步锁(支持多线程,但会影响效率)
 * @author ZHU
 *
 */

class LazySingle02{
	
	private LazySingle02(){}
	
	private static LazySingle02 single ;
	
	public static synchronized LazySingle02 getInstance() {
		if(single == null)
		{
			single = new LazySingle02() ;
		}
		return single;
	}
}
