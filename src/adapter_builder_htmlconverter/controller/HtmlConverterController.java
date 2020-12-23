package adapter_builder_htmlconverter.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import adapter_builder_htmlconverter.model.FileBuilder;
import adapter_builder_htmlconverter.model.PDFBuilder;
import adapter_builder_htmlconverter.model.PNGBuilder;
import adapter_builder_htmlconverter.view.HtmlConverterGUI;

public class HtmlConverterController implements ActionListener  {
	
	private FileBuilder fileBuilder;
	private ArrayList<File> files;
	
	public HtmlConverterController() {
		files = new ArrayList<File>();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(HtmlConverterGUI.getOpenItem())) {
			File f = openFile();
			if(f != null) {
				HtmlConverterGUI.processing(f.getName());
				files.add(f);
				HtmlConverterGUI.completed(f.getName());
			}
		}
		else if(e.getSource().equals(HtmlConverterGUI.getAboutItem())) {
			HtmlConverterGUI.about();
		}
		else {
			if(e.getSource().equals(HtmlConverterGUI.getRtfItem())) {
				fileBuilder = PDFBuilder.getInstance();
			}
			else {
				fileBuilder = PNGBuilder.getInstance();
			}
			
			int index = HtmlConverterGUI.getCurrentTabIndex();
			saveFile(index);
			HtmlConverterGUI.exported(files.get(index).getName(), fileBuilder.getExtension());
			
		}
		
	}
	
	public File openFile() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to import");   
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		FileFilter ff = new FileFilter(){
		    public String getDescription() {
		        return "HTML Files (*.html)";
		    }
		 
		    public boolean accept(File f) {
		        if (f.isDirectory()) {
		            return true;
		        } else {
		            return f.getName().toLowerCase().endsWith(".html") || f.getName().toLowerCase().endsWith(".htm");
		        }
		    }
		};
		fileChooser.addChoosableFileFilter(ff);
		fileChooser.setFileFilter(ff);
	
		int result = fileChooser.showOpenDialog(HtmlConverterGUI.getInstance());
		if (result == JFileChooser.APPROVE_OPTION)
			return fileChooser.getSelectedFile();	
		
		return null;
	}

	public void saveFile(int index) {
		if(index >= 0 && index < files.size()) {
			File convertedFile = fileBuilder.convertFile(files.get(index));
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Specify a file to save");   
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
			FileFilter ff = fileBuilder.getFileFilter();
			fileChooser.addChoosableFileFilter(ff);
			fileChooser.setFileFilter(ff);

			int userSelection = fileChooser.showSaveDialog(HtmlConverterGUI.getInstance());
			 
			if (userSelection == JFileChooser.APPROVE_OPTION) {
			    FileOutputStream outputStream;
				try {
					String filePath = fileChooser.getSelectedFile().getPath();
					if(!filePath.endsWith(fileBuilder.getExtension()))
						filePath += fileBuilder.getExtension();
					outputStream = new FileOutputStream(new File(filePath));
					byte[] fileToBytes = Files.readAllBytes(Paths.get(convertedFile.toURI()));
				    outputStream.write(fileToBytes);
				    outputStream.close();
				 
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			    
			}
			
		}
	}
	

	public void removeFile(int index) {
		if(index >= 0 && index < files.size()) {
			files.remove(index);
		}
	}

	
}
