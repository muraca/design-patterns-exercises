package bridge_asciiart.model;

public class ShellDesigner implements Designer {
	AsciiAbstraction abstraction;
	
	public ShellDesigner(AsciiAbstraction a) {
		abstraction = a;
	}
	
	@Override
	public void designShape() {
		System.out.println(abstraction.getInfo());
		System.out.println(abstraction.getAscii());
	}
	
}
