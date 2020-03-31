package thread_ex;

public class MusicPlayer extends Thread {

	int type;
	MusicBox musicBox;

	public MusicPlayer(int type, MusicBox musicBox) {
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
