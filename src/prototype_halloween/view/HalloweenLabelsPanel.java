package prototype_halloween.view;

import java.awt.Component;
import java.util.ArrayList;
import prototype_halloween.model.HalloweenLabel;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class HalloweenLabelsPanel extends JPanel {
	
	private static HalloweenLabelsPanel instance;
	public static HalloweenLabelsPanel getInstance() {
		if(instance == null)
			instance = new HalloweenLabelsPanel();
		return instance;
	}

	private HalloweenLabelsPanel() {
		super();
		setFocusable(true);
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		ArrayList<HalloweenLabel> labels = HalloweenLabel.getLabels();
		for(HalloweenLabel l: labels) {
			add(l, Component.LEFT_ALIGNMENT);
		}
		
	}
	
	private static final long serialVersionUID = 1064251118907753966L;
}
