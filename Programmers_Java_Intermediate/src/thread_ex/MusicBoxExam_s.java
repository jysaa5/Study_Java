package thread_ex;

public class MusicBoxExam_s {
	
	//한 개의 메서드가 다 실행되고 나서 그 다음 메서드가 실행됨.
	public static void main(String[] args) {
		MusicBox_s box = new MusicBox_s();
		
		MusicPlayer_s kang = new MusicPlayer_s(1, box);
		MusicPlayer_s kim = new MusicPlayer_s(2, box);
		MusicPlayer_s lee = new MusicPlayer_s(3, box);
		
		kang.start();
		kim.start();
		lee.start();
	}

}
