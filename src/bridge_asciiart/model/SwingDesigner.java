package bridge_asciiart.model;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class SwingDesigner implements Designer {
	AsciiAbstraction abstraction;
	
	public SwingDesigner(AsciiAbstraction a) {
		abstraction = a;
	}

	@Override
	public void designShape() {

		JFrame f = new JFrame(abstraction.getInfo());
		
		JTextArea a = new JTextArea(abstraction.getAscii());
		a.setEditable(false);
		a.setBounds(0,0,400,400);
		
		f.add(a);
		
		f.setSize(400,400);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		
	}
	
}
