package cli;

public class Light extends Device{
	
	public Light(String id) {
		this.id = id;
	}
	
	public void on(){
		this.status = true;
		System.out.println("The Light Device #"+id+" has been Turned ON;");
	}

	public void off(){
		this.status = false;
		System.out.println("The Light Device #"+id+" has been Turned OFF;");
	}

	public void status(){
		if(status){
			System.out.println("The Light Device #"+id+" is ON;");
		}else{
			System.out.println("The Light Device #"+id+" is OFF;");
		}
	}
	
	

}
