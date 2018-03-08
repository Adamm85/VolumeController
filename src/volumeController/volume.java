package volumeController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class volume {
	
	private int actualVolume = 0;
	private int minVolume = 0;
	private int maxVolume = 100;
	private int read = 0;
	private int i = 0;
	private String exit = "";
	private Scanner reader = null;
	private boolean isInt;
	

	public volume() {}
	
	public volume(int minVol, int maxVol) {
		minVolume = minVol;
		maxVolume = maxVol;
		actualVolume = minVol;
	}
	
	public int actualVolume() {
		return actualVolume;
	}
	
	public int maxVolume() {
		return maxVolume;
	}
	
	// Load value to change volume
	public void scanner() throws InputMismatchException {		
		isInt = true;
		reader = new Scanner(System.in);
		try {
			read = reader.nextInt();			
		} catch(Exception ex) {
			isInt = false;
			System.out.println("\n*****Error***** Wrong type of data or nothing to load *****\n");
		}
	}
	
	// Return read value by scanner
	public int inValue() {		
		return read;
	}
	
	// Set volume to the value of the task if it possible
	public int setVolume() {
		if(volumeRange() == false) {				
			return actualVolume;
		}
		return inValue();
	}
	
	// Check if the given value is outside the scope
		public boolean volumeRange() {
			if(inValue() > maxVolume | inValue() < minVolume)
				return false;
			else
				return true;
		}
		
	public void showVolumeChange() throws InterruptedException {
		int checkVolume = setVolume();
		if(checkVolume < actualVolume) {
			for (i = actualVolume; i >= checkVolume; i--)	{
				if(actualVolume >= minVolume) {
					Thread.sleep(10);
					System.out.print(i + " ");
					actualVolume = i;
				}
			}
		}
		if(checkVolume > actualVolume) {
			for (i = actualVolume; i <= checkVolume; i++) {
				Thread.sleep(10);
				System.out.print(i + " ");
				actualVolume = i;
			}
	    } 
	}			
		
	// Methods display the message depending on the condition
	public void currVolInformation() {
		if(volumeRange() == true & isInt == true & !exit.equals("exit"))
			System.out.println("The current volume is set to: " + actualVolume());
	}
	
	public void checkVolRange() {
		if(volumeRange() == false & isInt == true & !exit.equals("exit"))
			System.out.println("\n*****Error***** You went beyond the regulation range *****\n");
		else if(volumeRange() == true & isInt == true & !exit.equals("exit"))
			System.out.println("\nSet the volume to: " + setVolume() + "\n");
	}
	
	public void confVolSetting() {
		if(volumeRange() == true & isInt == true & !exit.equals("exit"))
			System.out.println("\n\nI confirm the volume setting on: " + actualVolume + "\n");
		}
	
	public void exitInfo() {
		if(exit.equals("exit")) {
			System.out.println("\nExit");
		}			
	}
	
	// Exit condition from the program 
	public String exit() {
		if( read == -1) {			
			return exit = "exit";
		}
		else
			return exit;
	}
}	

		
