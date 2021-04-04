package cli;

public abstract class Device{
	public String id;
	public boolean status = false;
	public abstract void open();
	public abstract void close();
	public abstract void status();

}
