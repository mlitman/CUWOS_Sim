import java.io.File;
import java.util.LinkedList;

class PCB_State
{
	static int NEW = 0;
	static int READY = 1;
	static int RUNNING = 2;
	static int WAITING = 3;
	static int TERMINATED = 4;
}

class Register
{
	private String name;
	private String binaryValue;
}

public class PCB 
{
	private int pid;
	private int state;
	private int timeSlice;
	private PCB parent;
	private LinkedList<PCB> children = new LinkedList<PCB>();
	private LinkedList<File> openFiles = new LinkedList<File>();
	private LinkedList<String> instructions = new LinkedList<String>();
	private LinkedList<Register> registerValues = new LinkedList<Register>();
	private int programCounter = 0;
	
	public PCB(int pid, PCB parent, LinkedList<String> instructions)
	{
		this.pid = pid;
		this.state = PCB_State.NEW;
		this.timeSlice = 0;
		this.parent = parent;
		this.instructions = instructions;
	}

	public int getTimeSlice() 
	{
		return timeSlice;
	}

	public void setStateReady()
	{
		this.state = PCB_State.READY;
	}
	
	public void setStateRunning()
	{
		this.state = PCB_State.RUNNING;
	}
	
	public void setStateWaiting()
	{
		this.state = PCB_State.WAITING;
	}
	
	public void setStateTerminated()
	{
		this.state = PCB_State.TERMINATED;
	}
	
	public void setTimeSlice(int timeSlice) 
	{
		this.timeSlice = timeSlice;
	}
	
}
