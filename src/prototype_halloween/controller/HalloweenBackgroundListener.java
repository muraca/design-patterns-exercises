package prototype_halloween.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import prototype_halloween.model.HalloweenImages;
import prototype_halloween.view.HalloweenDrawPanel;

public class HalloweenBackgroundListener implements MouseListener {
	
	private int index;
	
	public HalloweenBackgroundListener(int index) {
		this.index = index;
	}

	@Override
	public void mouseClicked(MouseEvent e) { }

	@Override
	public void mousePressed(MouseEvent e) { 
		HalloweenDrawPanel.getInstance().setBackground(HalloweenImages.getBackgrounds().get(index));
	}

	@Override
	public void mouseReleased(MouseEvent e) { }

	@Override
	public void mouseEntered(MouseEvent e) { }

	@Override
	public void mouseExited(MouseEvent e) { }
}