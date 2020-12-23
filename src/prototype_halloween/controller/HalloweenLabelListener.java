package prototype_halloween.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HalloweenLabelListener implements MouseListener {
	
	private int index;
	
	public HalloweenLabelListener(int index) {
		this.index = index;
	}

	@Override
	public void mouseClicked(MouseEvent e) { }

	@Override
	public void mousePressed(MouseEvent e) { 
		HalloweenController.setClickedLabel(index);
	}

	@Override
	public void mouseReleased(MouseEvent e) { }

	@Override
	public void mouseEntered(MouseEvent e) { }

	@Override
	public void mouseExited(MouseEvent e) { }
}