package interface_ex;

public interface TV {
	
	//»ó¼ö
	public int MIN_VOLUNE = 0;
	
	public int MAX_VOLUNE = 100;
	
	public void turnOn();
	
	public void turnOff();
	
	public void changeVolume(int volume);
	
	public void changeChannel(int channel);
	

}
