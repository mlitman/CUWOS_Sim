import java.util.LinkedList;

class Register
{
	private String name;
	private String binaryValue;
	
	public Register(String name)
	{
		this.name = name;
		this.binaryValue = "00000000";
	}

	public String getBinaryValue() {
		return binaryValue;
	}

	public void setBinaryValue(String binaryValue) {
		this.binaryValue = binaryValue;
	}

	public String getName() {
		return name;
	}
}

public class CPU 
{
	private PCB thePCB;
	private LinkedList<Register> theRegisters = new LinkedList<Register>();
	
	public CPU()
	{
		this.thePCB = null;
		this.theRegisters.add(new Register("AX"));
		this.theRegisters.add(new Register("BX"));
		this.theRegisters.add(new Register("CX"));
		this.theRegisters.add(new Register("DX"));
	}
	
	public void contextSwitchIn(PCB p)
	{
		for(Register r : this.theRegisters)
		{
			String val = p.getValueForRegister(r.getName());
			if(val != null)
			{
				r.setBinaryValue(val);
			}
		}
		this.thePCB = p;
	}
	
	public PCB contextSwitchOut()
	{
		//store all of the Register values in the current PCB
		//set the current PCB to null
		//return the PCB that is leaving the CPU
	}
}
