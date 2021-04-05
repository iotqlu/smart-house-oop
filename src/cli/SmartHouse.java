package cli;

import java.util.*;
import java.io.*;

public class SmartHouse{

	private List<Device> devices = new ArrayList<>();

	private void installDevice(Device device){
		devices.add(device);
	}

	private void retireDevice(String id){
		for(Device device:devices){
			if(id.equalsIgnoreCase(device.id)){
				devices.remove(device);
			}
		}
	}
	
	private void retireDevice(Device dev){
		devices.remove(dev);
	}

	private void status(){
		for(Device device:devices){
			device.status();
		}
	}
	
	public void dashboard() {	
		try {
			menu();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void menu() throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String menu = "[1] Install Device\n"
				+ "[2] Retire Device\n"
				+ "[3] Show Status\n"
				+ "[4] Control Device\n"
				+ "[Q] Quit\n"
				+ "> ";
		
		System.out.println("");
		System.out.print(menu);
		
		
		switch(br.readLine()) {
		case "1": submenu_1(); break;
		case "2": submenu_2(); break;
		case "3": submenu_3(); break;
		case "4": submenu_4(); break;
		case "q":
		case "Q": System.out.println("Bye!"); break;
		default : System.out.println("Invalid Option!"); menu(); break;
		}
		
		
	}
	
	private void submenu_1() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String menu = "[1] Install a Light\n"
				+ "[2] Install a A/C\n"
				+ "[Q] Quit\n"
				+ "> ";
		System.out.println("");
		System.out.print(menu);
		
		switch(br.readLine()) {
		case "1": submenu_1_1();break;
		case "2": submenu_1_2();break;
		case "q":
		case "Q": menu();break;
		default : System.out.println("Invalid Option!"); submenu_1(); break;
		}
	}
	
	private void submenu_1_1() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("> Input the Light ID: # ");
		String id = br.readLine();
		Light light = new Light();
		light.id = id;
		devices.add(light);
		System.out.format("The Light %s has been installed successfully!\n", id);
		submenu_1();
	}
	
	private void submenu_1_2() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("> Input the A/C  ID: # ");
		String id = br.readLine();
		AC ac = new AC();
		ac.id = id;
		devices.add(ac);
		System.out.format("The AC %s has been installed successfully!\n", id);
		submenu_1();
	}
	
	private void submenu_2() throws IOException {
		for(int i = 0;i<devices.size();i++) {
			Device device = devices.get(i);
			if(device instanceof Light) {
				System.out.format("[%s] Light #%s\n", i+1, device.id);
			}else if(device instanceof AC){
				System.out.format("[%s] A/C #%s\n", i+1, device.id);
			}
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("> Choose the Device to be Retired. (type q to quit): #");
		String str = br.readLine();
		if("q".equalsIgnoreCase(str)) {
			menu();
		}else{
			try {
				int index = Integer.parseInt(str);
				Device device = devices.get(index-1);
				this.retireDevice(device);
				if(device instanceof Light) {
					System.out.format("The Light #%s has been retired successfully!", device.id);
				}else if(device instanceof AC) {
					System.out.format("The A/C #%s has been retired successfully!", device.id);
				}
				menu();
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("Invalid Input!");
				submenu_2();
			}
		}
		
	}
	
	private void submenu_3() throws IOException {
		status();
		menu();
	}
	
	private void submenu_4() throws IOException {
		for(int i = 0;i<devices.size();i++) {
			Device device = devices.get(i);
			if(device instanceof Light) {
				System.out.format("[%s] Light #%s \n", i+1, device.id);
			}else if(device instanceof AC){
				System.out.format("[%s] A/C #%s \n", i+1, device.id);
			}
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("> Choose the Device to be Controlled. (type q to quit): # ");
		String str = br.readLine();
		if("q".equalsIgnoreCase(str)) {
			menu();
		}else {
			try {
				int index = Integer.parseInt(str);
				Device device = devices.get(index-1);
				
				subsubmenu_4(device);
				
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("Invalid Input!");
				submenu_4();
			}
		}
	}
	
	private void subsubmenu_4(Device device) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("");
		System.out.println("[1] Turn On");
		System.out.println("[2] Turn Off");
		System.out.println("[Q] Quit");
		
		if(device instanceof Light) {
			System.out.format("> Choose how would you like to control Light %s: \n> ", device.id);
		}else if(device instanceof AC) {
			System.out.format("> Choose how would you like to control A/C %s: \n> ", device.id);
		}
		
		String str = br.readLine();
		
		if("q".equalsIgnoreCase(str)) {
			submenu_4();
		}else if("1".equals(str)) {
			device.on();
			submenu_4();
		}else if("2".equals(str)) {
			device.off();
			submenu_4();
		}else {
			System.out.println("Invalid Input!");
			subsubmenu_4(device);
		}
	}
	


	public static void main(String args[]){

		SmartHouse sh = new SmartHouse();
		sh.dashboard();
		

	}
}








