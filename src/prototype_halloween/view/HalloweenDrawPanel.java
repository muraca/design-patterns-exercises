package prototype_halloween.view;

import javax.swing.JPanel;

import prototype_halloween.controller.HalloweenDrawPanelListener;
import prototype_halloween.model.HalloweenImages;

import java.awt.Graphics;
import java.awt.Image;

public class HalloweenDrawPanel extends JPanel {
	
	private static HalloweenDrawPanel instance;
	public static HalloweenDrawPanel getInstance() {
		if(instance == null)
			instance = new HalloweenDrawPanel();
		return instance;
	}

	private Image background;
	private HalloweenDrawPanel() {
		super();
		setLayout(null);
		addMouseListener(HalloweenDrawPanelListener.getInstance());
		background = HalloweenImages.getBackgrounds().get(0);
	}
	
	public void setBackground(Image newBG) {
		background = newBG;
		repaint();
	}
	
	public void clear() {
		removeAll();
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(background != null)
			g.drawImage(background, 0, 0, null);
		
	}
	
	private static final long serialVersionUID = 6038822150403745169L;

	
	
}
