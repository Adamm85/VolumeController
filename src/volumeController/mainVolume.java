package volumeController;

public class mainVolume {
	
	public mainVolume() {
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		volume volume = new volume(1000, 2000);
		String leave = volume.exit();
		while (!leave.equals("exit")) {
			System.out.println("Adjust the volume:\n");
			volume.scanner();
			leave = volume.exit();	
			volume.checkVolRange();	
			volume.currVolInformation();
			volume.setVolume();
			volume.showVolumeChange();
			volume.confVolSetting();					
			volume.exitInfo();
		}
	}
}
