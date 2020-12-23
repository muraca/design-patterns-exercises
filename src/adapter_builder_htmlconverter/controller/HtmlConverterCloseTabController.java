package adapter_builder_htmlconverter.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import adapter_builder_htmlconverter.view.HtmlConverterGUI;

public class HtmlConverterCloseTabController implements ActionListener {
	 
	private HtmlConverterController mainController;
	
	public HtmlConverterCloseTabController(HtmlConverterController mainController) {
		this.mainController = mainController;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int removed = HtmlConverterGUI.removeCurrentTab();
		mainController.removeFile(removed);
	}
}
