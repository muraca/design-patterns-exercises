package prototype_halloween.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import prototype_halloween.model.HalloweenLabel;



public class HalloweenBGPanel extends JPanel {
	
	private static HalloweenBGPanel instance;
	public static HalloweenBGPanel getInstance() {
		if(instance == null)
			instance = new HalloweenBGPanel();
		return instance;
	}
	

	private HalloweenBGPanel() {
		super();
		setLayout(new GridLayout());
		
		ArrayList<HalloweenLabel> bgs = HalloweenLabel.getBackgrounds();
		for(HalloweenLabel l: bgs)
			add(l);

		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				HalloweenDrawPanel.getInstance().clear();
			}
			
		});
		add(clearButton);
	}
	
	
	private static final long serialVersionUID = 4571954319040280379L;

}
