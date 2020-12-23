package prototype_halloween.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import prototype_halloween.view.HalloweenDrawPanel;

public class HalloweenDrawPanelListener implements MouseListener {

	public static HalloweenDrawPanelListener instance = null;
	
	public static HalloweenDrawPanelListener getInstance() {
		if(instance == null)
			instance = new HalloweenDrawPanelListener();
		return instance;
	}
	
	private HalloweenDrawPanelListener() {}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		HalloweenDrawPanel.getInstance().add(HalloweenController.getClickedLabel(e.getX(), e.getY()));
		HalloweenDrawPanel.getInstance().repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) { }

	@Override
	public void mouseEntered(MouseEvent e) { }

	@Override
	public void mouseExited(MouseEvent e) { }
	
}


