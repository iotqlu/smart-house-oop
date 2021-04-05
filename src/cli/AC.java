package cli;

public class AC extends Device{
	
	public AC(String id) {
		this.id = id;
	}

	public void on(){
		this.status = true;
		System.out.println("The A/C Device #"+id+" has been Turned ON;");
	}

	public void off(){
		this.status = false;
		System.out.println("The A/C Device #"+id+" has been Turned OFF;");
	}

	public void status(){
		if(status){
			System.out.println("The A/C Device #"+id+" is ON;");
		}else{
			System.out.println("The A/C Device #"+id+" is OFF;");
		}
	}

}
