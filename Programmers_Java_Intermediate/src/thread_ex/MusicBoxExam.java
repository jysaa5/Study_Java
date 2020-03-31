package thread_ex;

public class MusicBoxExam {
	
	//순서가 왔다갔다 하면서 실행된다.
	public static void main(String[] args) {
		MusicBox box = new MusicBox();
		
		MusicPlayer kang = new MusicPlayer(1, box);
		MusicPlayer kim = new MusicPlayer(2, box);
		MusicPlayer lee = new MusicPlayer(3, box);
		
		kang.start();
		kim.start();
		lee.start();
	}

}
