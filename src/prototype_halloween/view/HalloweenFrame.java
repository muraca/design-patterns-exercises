package prototype_halloween.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;


public class HalloweenFrame extends JFrame{
	
	private static HalloweenFrame instance = null;
	
	public static void init() {
		if(instance == null)
			instance = new HalloweenFrame();
	}
	
	public static HalloweenFrame getInstance() {
		init();
		return instance;
	}
	
	private HalloweenFrame() {
		super("Halloween Decorations Generator by Matteo Muraca");
		setSize(800, 600);
		
		JScrollPane leftPane = new JScrollPane(HalloweenLabelsPanel.getInstance());
		
		JSplitPane rightSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		rightSplitPane.setDividerSize(1);
		rightSplitPane.setDividerLocation(500);
		rightSplitPane.setOneTouchExpandable(false);
		
		rightSplitPane.add(HalloweenDrawPanel.getInstance());
		rightSplitPane.add(HalloweenBGPanel.getInstance());
		
		
		JSplitPane mainSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		mainSplitPane.setDividerSize(1);
		mainSplitPane.setDividerLocation(125);
		mainSplitPane.setOneTouchExpandable(false);
		
		mainSplitPane.add(leftPane);
		mainSplitPane.add(rightSplitPane);
		
		this.add(mainSplitPane);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-400, dim.height/2-300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}
	
	public static void main(String[] args) {
		init();
	}
	
	private static final long serialVersionUID = 963425547675428699L;

}
