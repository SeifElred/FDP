package facadedesignpattern;


// Subsystems
class Ram {
	public void chkRAMStatus() {
		System.out.println("The RAM is working Fine");
	}
}

class Cpu {
	public void chkCPUStatus() {
		System.out.println("The CPU is working Fine");
	}
}
class Harddisk {
	public void chkHDDStatus() {
		System.out.println("The Harddisk is working Fine");
	}
}

// Facade Class

class Facade {
	private Ram r;
	private Cpu c;
	private Harddisk hd;
	
	Facade() {
		this.r = new Ram();
		this.c = new Cpu();
		this.hd = new Harddisk();
	}
	
	public void start() {
		r.chkRAMStatus();
		c.chkCPUStatus();
		hd.chkHDDStatus();
	}
}
// Client
public class Main {
	public static void main(String[] args) {
		Facade facade = new Facade();
		
		facade.start();
	}
}
