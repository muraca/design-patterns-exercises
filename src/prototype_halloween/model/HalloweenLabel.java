package prototype_halloween.model;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import prototype_halloween.controller.HalloweenBackgroundListener;
import prototype_halloween.controller.HalloweenLabelListener;

public class HalloweenLabel extends JLabel {
	
	private static ArrayList<HalloweenLabel> labels = null;
	
	private static void initLabels() {
		labels = new ArrayList<HalloweenLabel>();
		ArrayList<ImageIcon> decs = HalloweenImages.getDecorations();
		for(int i=0; i<decs.size(); i++) {
			HalloweenLabel lab = new HalloweenLabel(decs.get(i));
			lab.addMouseListener(new HalloweenLabelListener(i));
			labels.add(lab);
		}
	}
	
	public static ArrayList<HalloweenLabel> getLabels() {
		if(labels == null)
			initLabels();
		return labels;
	}
	
	private static ArrayList<HalloweenLabel> bgs = null;
	
	private static void initBgs() {
		bgs = new ArrayList<HalloweenLabel>();
		ArrayList<Image> imgs = HalloweenImages.getBackgrounds();
		for(int i=0; i<imgs.size(); i++) {
			HalloweenLabel lab = new HalloweenLabel(new ImageIcon(imgs.get(i)));
			lab.addMouseListener(new HalloweenBackgroundListener(i));
			bgs.add(lab);
		}
	}
	
	public static ArrayList<HalloweenLabel> getBackgrounds() {
		if(bgs == null)
			initBgs();
		return bgs;
	}

	private HalloweenLabel(ImageIcon img) {
		super();
		super.setIcon(img);
		super.setBounds(0,0,100,100);
	}
	
	public HalloweenLabel clone(int x, int y) {
		HalloweenLabel cloneLabel = new HalloweenLabel((ImageIcon) this.getIcon());
		cloneLabel.setBounds(x, y, 100, 100);
		return cloneLabel;
	}
	
	private static final long serialVersionUID = 5136961650759900554L;

}
