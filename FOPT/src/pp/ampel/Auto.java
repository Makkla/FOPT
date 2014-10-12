package pp.ampel;

public class Auto extends Thread{
	static int counter=0;
	private int autoNummer;
	private Ampel[] ampeln;
	
	public Auto(Ampel[] ampeln){
		
		this.autoNummer=counter;
		counter++;
		
		this.ampeln = ampeln;
		
	}
	
	public void run(){
		
		while (true){
			
			for (int i=0; i<ampeln.length; i++){
				System.out.println("Auto # "+autoNummer+" will passieren");
				ampeln[i].passieren();
				
			}
			
		}
		
	}
		
}
