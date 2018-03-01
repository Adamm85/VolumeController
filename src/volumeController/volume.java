package volumeController;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class volume {
	
	int actualVolumee = 0;
	int maxVolumee = 100;
	int setVolume = 0;	
	int read = 0;
	int i = 0;
	String exit = "";
	Scanner reader = null;
	boolean isInt;
	

	public volume() {}
	
	public volume(int actualVolume, int maxVolume) {
		actualVolume = actualVolumee;
		maxVolume = maxVolumee;
	}
	
	public int actualVolume() {
		return actualVolumee;
	}
	
	public int maxVolume() {
		return maxVolumee;
	}
	
	// Load value to change volume
	public void scanner() throws InputMismatchException {		
		isInt = true;
		reader = new Scanner(System.in);
		try {
			read = reader.nextInt();			
		} catch(NoSuchElementException|NumberFormatException ex) {
			isInt = false;
			System.out.println("\n*****Error***** Wrong type of data or nothing to load *****\n");}
	}
	
	// Return read value by scanner
	public int inValue() {		
		return read;
	}
	
	// Set volume to the value of the task if it possible
	public int setVolume() {
		if(volumeRange() == false) {				
			return setVolume = actualVolumee;
		}
		return setVolume = inValue();
	}
	
	// Check if the given value is outside the scope
		public boolean volumeRange() {
			if(inValue() > maxVolumee | inValue() < 0)
				return false;
			else
				return true;
		}
		
	public void showVolumeChange() throws InterruptedException {
		if(setVolume() < actualVolumee) {
			for (i = actualVolumee; i >= setVolume(); i--)	{
				if(actualVolumee >= 0) {
					Thread.sleep(20);
					System.out.print(i + " ");
					actualVolumee = i;
				}
			}
		}
		if(setVolume() > actualVolumee) {
			for (i = actualVolumee; i <= setVolume(); i++) {
				Thread.sleep(20);
				System.out.print(i + " ");
				actualVolumee = i;
			}
	    } 
	}			
		
	// Methods display the message depending on the condition
	public void currVolInformation() {
		if(volumeRange() == true & isInt == true & !exit.equals("exit"))
			System.out.println("The current volume is set to: " + actualVolume());
	}
	
	public void checkVolRange() {
		if(volumeRange() == false & !exit.equals("exit"))
			System.out.println("\n*****Error***** You went beyond the regulation range *****\n");
		else if(volumeRange() == true & isInt == true & !exit.equals("exit"))
			System.out.println("\nSet the volume to: " + setVolume() + "\n");
	}
	
	public void confVolSetting() {
		if(volumeRange() == true & isInt == true & !exit.equals("exit"))
			System.out.println("\n\nI confirm the volume setting on: " + actualVolumee + "\n");
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

		
