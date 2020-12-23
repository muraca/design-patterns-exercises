package factory_carseller;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import factory_carseller.cars.Car;
//ho utilizzato un CardLayout per spostarsi tra i vari JPanel
public class Display extends JFrame {
	
	private static final long serialVersionUID = 4758875378058672987L;
	private Controller controller;
	private CardLayout layout;
	private Container container;
	private JPanel panel1 = null;
	private JPanel panel2 = null;
	private JPanel panel3 = null;
	
	Display(Controller c) {
		super("Concessionaria");
		controller = c;
		container = getContentPane();
		layout = new CardLayout();
		container.setLayout(layout);
		
		setSize(800, 600);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-400, dim.height/2-300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void showPanel1() {
		if(panel1 == null)
			initPanel1();
		layout.show(container, "panel1");
		panel1.revalidate();
		
	}
	
	private void initPanel1() {
		panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setFocusable(true);
		
		JLabel title = new JLabel("Scegli la marca:");
		panel1.add(title);
		title.setBounds(350, 100, 100, 50);
		
		String[] brandsList = {"Audi", "Fiat", "Peugeot"};
		JComboBox<String> brands = new JComboBox<String>(brandsList);
		panel1.add(brands);
		brands.setBounds(300, 185, 125, 30);
		
		JButton button = new JButton("Vai");
		button.addActionListener(new ActionListener() {
			//comunica al controller la volontà di scegliere un determinato brand
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.setBrand((String) brands.getSelectedItem());
				showPanel2();
				
			}
			
		});
		panel1.add(button);
		button.setBounds(450, 185, 50, 30);
		
		container.add("panel1", panel1);
	}

	private void showPanel2() {
		if(panel2 == null)
			initPanel2();
		layout.show(container, "panel2");
		panel2.revalidate();
	}
	
	private void initPanel2() {
		panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setFocusable(true);
		
		JLabel title = new JLabel("Scegli la tipologia:");
		panel2.add(title);
		title.setBounds(350, 100, 150, 50);
		
		String[] typeList = {"Berlina", "Utilitaria", "Sportiva", "Furgoncino"};
		JComboBox<String> types = new JComboBox<String>(typeList);
		panel2.add(types);
		types.setBounds(300, 185, 125, 30);
		
		JButton button = new JButton("Vai");
		button.addActionListener(new ActionListener() {
			//comunica al controller la volontà di scegliere una determinata tipologia
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.setType((String) types.getSelectedItem());
				showPanel3();
			}
			
		});
		panel2.add(button);
		button.setBounds(450, 185, 50, 30);
		
		container.add("panel2", panel2);
	}
	
	private void showPanel3() {
		
		initPanel3();
		layout.show(container, "panel3");
		panel3.revalidate();
	}
	
	private void initPanel3() {
		panel3 = new JPanel();
		panel3.setLayout(null);
		panel3.setFocusable(true);
		
		List<Car> carsToShow = controller.getCars();
		
		JTextArea cars = new JTextArea();
		String textForTextArea = "";
		if(carsToShow.isEmpty())
			textForTextArea = "Nessuna macchina corrisponde ai requisiti.";
		else {
			for(Car c: carsToShow)
				textForTextArea += c.toString() + "\n";
		}
		cars.setText(textForTextArea);
		cars.setEditable(false);
		panel3.add(cars);
		cars.setBounds(200, 100, 400, 400);
		
		JButton chooseType = new JButton("Cambia tipo");
		chooseType.addActionListener(new ActionListener() {
			//per cambiare tipologia basta tornare al pannello precedente
			@Override
			public void actionPerformed(ActionEvent e) {
				showPanel2();
			}
			
		});
		panel3.add(chooseType);
		chooseType.setBounds(200, 500, 200, 30);
		
		JButton resetButton = new JButton("Ricomincia");
		resetButton.addActionListener(new ActionListener() {
			//comunica al controller la volontà di resettare la ricerca
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.reset();
				showPanel1();
			}
			
		});
		panel3.add(resetButton);
		resetButton.setBounds(400, 500, 200, 30);
		
		
		container.add("panel3", panel3);
	}

	public static void main(String[] args) {
		Controller c = new Controller();
		Display d = new Display(c);
		d.showPanel1();
	}
}
