package prototype_halloween.model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class HalloweenImages {
	
	private static ArrayList<ImageIcon> decorations = null;
	private static int dec_size = 9;
	
	
	private static void initDecorations() {
		decorations = new ArrayList<ImageIcon>();

		for(int i=0; i < dec_size; i++) {
			try {
				decorations.add(new ImageIcon(ImageIO.read(new File("src/resources/halloweendecorations/" + i + "-redim.png"))));;
				
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}
	
	static ArrayList<ImageIcon> getDecorations() {
		if(decorations == null)
			initDecorations();
		return decorations;
	}
	
	
	private static ArrayList<Image> backgrounds = null;
	private static int bg_size = 3;
	
	private static void initBackgrounds() {
		backgrounds = new ArrayList<Image>();

		for(int i=0; i < bg_size; i++)
			try {
				backgrounds.add(ImageIO.read((new File("src/resources/halloweenbackgrounds/" + i + ".jpg"))));
			} catch (IOException e) {
				e.printStackTrace();
			}
				
	}
	
	public static ArrayList<Image> getBackgrounds() {
		if(backgrounds == null)
			initBackgrounds();
		return backgrounds;
	}
	
}
