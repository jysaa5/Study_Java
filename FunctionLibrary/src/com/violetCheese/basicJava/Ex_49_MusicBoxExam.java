package com.violetCheese.basicJava;

public class Ex_49_MusicBoxExam {
	
	//순서가 왔다갔다 하면서 실행된다.
	public static void main(String[] args) {
		Ex_47_MusicBox box = new Ex_47_MusicBox();
		
		Ex_48_MusicPlayer kang = new Ex_48_MusicPlayer(1, box);
		Ex_48_MusicPlayer kim = new Ex_48_MusicPlayer(2, box);
		Ex_48_MusicPlayer lee = new Ex_48_MusicPlayer(3, box);
		
		kang.start();
		kim.start();
		lee.start();
	}

}
