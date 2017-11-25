package strategy;

/*
 * 这里是老式CD机
 */
public class OldCDplayer {

	public void playMusic(String singer){
		if(singer == "jay"){
			
			System.out.println("我是周杰伦我在演唱");
			System.out.println("青花瓷");
			System.out.println("双截棍");
			System.out.println("七里香");
			System.out.println("发如雪");	
			
		}else if(singer == "li"){
			System.out.println("我是李荣浩我在演唱");
			System.out.println("模特");
			System.out.println("李白");
			System.out.println("爸爸妈妈");	
		}else{
			System.out.println("没有该歌手");
		}
	}
}
