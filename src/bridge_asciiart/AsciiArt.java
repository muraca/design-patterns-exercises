package bridge_asciiart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import bridge_asciiart.model.ShellDesigner;
import bridge_asciiart.model.SwingDesigner;
import bridge_asciiart.model.AsciiAbstraction;
import bridge_asciiart.model.CircleAbstraction;
import bridge_asciiart.model.CubeAbstraction;
import bridge_asciiart.model.Designer;
import bridge_asciiart.model.PinocchioAbstraction;

public class AsciiArt {
	public static void main(String[] args) {
		AsciiAbstraction abs = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Choose abstraction: circle, cube, pinocchio.");
		String absStr = null;
		
		while(abs == null) {
			try {
				absStr = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			} 
			
			if(absStr.equalsIgnoreCase("circle"))
				abs = new CircleAbstraction();
			else if(absStr.equalsIgnoreCase("cube"))
				abs = new CubeAbstraction();
			else if(absStr.equalsIgnoreCase("pinocchio"))
				abs = new PinocchioAbstraction();
			else 
				System.out.println("Try again!");
		
		}
		
		Designer d = new ShellDesigner(abs);
		d.designShape();
		
		d = new SwingDesigner(abs);
		d.designShape();
	}
}
