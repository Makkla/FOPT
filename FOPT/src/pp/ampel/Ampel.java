package pp.ampel;

public class Ampel {
	
	private boolean isGreen;
	
	public Ampel(){
		
		isGreen = false;
		System.out.println("neue Ampel erzeugt: #");
	}
	
	public synchronized void  setGreen(){		
		
		isGreen=true;
		notifyAll();
		
	}

	
	public synchronized void setRed(){
		
		isGreen=false;
		
	}
	
	public synchronized void passieren(){
		
		while (!isGreen){
			
			try {
				System.out.println("Auto muss warten");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Auto darf passieren");
		//notifyAll();
		
	}
	
	
}
