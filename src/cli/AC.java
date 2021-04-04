package cli;

public class AC extends Device{

	public void open(){
		this.status = true;
		System.out.println("The A/C Device #"+id+" has been Turned ON;");
	}

	public void close(){
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
