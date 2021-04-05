package cli;

public abstract class Device{
	public String id;
	public boolean status = false;
	public abstract void on();
	public abstract void off();
	public abstract void status();

}
