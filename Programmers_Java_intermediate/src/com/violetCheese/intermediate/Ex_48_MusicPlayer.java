package com.violetCheese.intermediate;

public class Ex_48_MusicPlayer extends Thread {

	int type;
	Ex_47_MusicBox musicBox;

	public Ex_48_MusicPlayer(int type, Ex_47_MusicBox musicBox) {
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
