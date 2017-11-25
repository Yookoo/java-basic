package proxy4;

public class Test {


	public static void main(String[] args) {
		Worker worker = new Worker();
		Student student = new Student();
		Singer singer = new Singer(); 
		ProxyBuilder proxyBuilder = new ProxyBuilder();
		Worker workerProxy = (Worker)proxyBuilder.setProxy(worker).build();
		//student = (Student)proxyBuilder.setProxy(student).build();
		//Singer singerProxy = (Singer)proxyBuilder.setProxy(singer).build();
		//student.study();
		//student.doHomework();
		//singerProxy.sing("∆ﬂ¿Ôœ„");
		workerProxy.work();
	}

}
