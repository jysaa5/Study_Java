package com.violetCheese.intermediate;

public class Ex_51_MusicPlayer_s extends Thread {

	int type;
	Ex_50_MusicBox_s musicBox;

	public Ex_51_MusicPlayer_s(int type, Ex_50_MusicBox_s musicBox) {
		this.type = type;
		this.musicBox = musicBox;
	}

	@Override
	public void run() {

		super.run();

		switch (type) {

		case 1:
			musicBox.playMusicA();
			break;
		case 2:
			musicBox.playMusicB();
			break;

		case 3:
			musicBox.playMusicC();
			break;

		}

	}

}
