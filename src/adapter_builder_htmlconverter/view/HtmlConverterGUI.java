package adapter_builder_htmlconverter.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import adapter_builder_htmlconverter.controller.HtmlConverterCloseTabController;
import adapter_builder_htmlconverter.controller.HtmlConverterController;

public class HtmlConverterGUI extends JFrame {
	
	
	private JTabbedPane tabs;
	
	private JMenuItem openItem;
	private JMenuItem pdfItem;
	private JMenuItem pngItem;	
	private JMenuItem aboutItem;
	
	private HtmlConverterController controller;
	private HtmlConverterCloseTabController closeTabController;
	
	private static HtmlConverterGUI instance = null;

	
	public static void init() {
		if(instance == null)
			instance = new HtmlConverterGUI();
	}
	
	public static HtmlConverterGUI getInstance() {
		init();
		return instance;
	}
	
	private HtmlConverterGUI() {
		super("HTML Converter by Matteo Muraca");
		setSize(800, 600);
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		openItem = new JMenuItem("Import HTML File");
		fileMenu.add(openItem);
		
		JMenu exportMenu = new JMenu("Export to");
		pdfItem = new JMenuItem("Portable Document Format .pdf");
		pngItem = new JMenuItem("Portable Network Graphics .png");
		exportMenu.add(pdfItem);
		exportMenu.add(pngItem);
		fileMenu.add(exportMenu);
		
		JMenu infoMenu = new JMenu("Info");
		aboutItem = new JMenuItem("About HTML Converter");
		infoMenu.add(aboutItem);
		
		menuBar.add(fileMenu);
		menuBar.add(infoMenu);
		
		controller = new HtmlConverterController();
		closeTabController = new HtmlConverterCloseTabController(controller);
		openItem.addActionListener(controller);
		pdfItem.addActionListener(controller);
		pngItem.addActionListener(controller);
		aboutItem.addActionListener(controller);
		
		setJMenuBar(menuBar);
		
		tabs = new JTabbedPane();
		add(tabs);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-400, dim.height/2-300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}
	
	public static void addTab(String title, Component component) {
		instance.tabs.addTab(title, component);
		int index = instance.tabs.indexOfTab(title);
		JPanel pnlTab = new JPanel(new GridBagLayout());
		pnlTab.setOpaque(false);
		JLabel lblTitle = new JLabel(title);
		JButton btnClose = new JButton("x");

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;

		pnlTab.add(lblTitle, gbc);

		gbc.gridx++;
		gbc.weightx = 0;
		pnlTab.add(btnClose, gbc);

		instance.tabs.setTabComponentAt(index, pnlTab);

		btnClose.addActionListener(instance.closeTabController);
			
	}
	
	public static int getCurrentTabIndex() {
		return instance.tabs.getSelectedIndex();
	}
	
	public static int removeCurrentTab() {
		int selected = instance.tabs.getSelectedIndex();
		if(selected != -1)
			instance.tabs.remove(selected);
		return selected;
	}
	
	public static void removeAllTabs() {
		instance.tabs.removeAll();
	}
	
	public static void processing(String filename) {
		JLabel label = new JLabel("processing " + filename);
		addTab(filename, label);
	}
	
	public static void completed(String filename) {
		Component c = instance.tabs.getComponent(instance.tabs.indexOfTab(filename));
		if(c instanceof JLabel) {
			JLabel label = (JLabel) c;
			label.setText(filename + " processed");
		}
	}
	
	public static void exported(String filename, String format) {
		Component c = instance.tabs.getComponent(instance.tabs.indexOfTab(filename));
		if(c instanceof JLabel) {
			JLabel label = (JLabel) c;
			label.setText(filename + " exported to " + format);
		}
	}
	
	public static void about() {
		JOptionPane infopane = new JOptionPane("©2020 Matteo Muraca, made for INGSW Course", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION);
		infopane.setOpaque(true);
		
		JDialog dialog = infopane.createDialog(instance, "About HTML Converter");
		dialog.setVisible(true);
	}

	public static JMenuItem getOpenItem() {
		return instance.openItem;
	}

	public static JMenuItem getRtfItem() {
		return instance.pdfItem;
	}

	public static JMenuItem getPngItem() {
		return instance.pngItem;
	}

	public static JMenuItem getAboutItem() {
		return instance.aboutItem;
	}
	
	private static final long serialVersionUID = 7164809933370627311L;

}
