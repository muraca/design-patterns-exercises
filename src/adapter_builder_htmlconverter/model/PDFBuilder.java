package adapter_builder_htmlconverter.model;

import java.awt.Insets;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import javax.swing.filechooser.FileFilter;

import org.zefer.pd4ml.PD4Constants;
import org.zefer.pd4ml.PD4ML;

//adapted PD4ML to my FileBuilder interface
public class PDFBuilder extends FileBuilder{
	private PD4ML pd4ml;
	
	private PDFBuilder() {
		fileFilter = new FileFilter(){
		    public String getDescription() {
		        return "PDF Files (*.pdf)";
		    }
		 
		    public boolean accept(File f) {
		        if (f.isDirectory()) {
		            return true;
		        } else {
		            return f.getName().toLowerCase().endsWith(".pdf");
		        }
		    }
		};
		pd4ml = new PD4ML();  
        
        pd4ml.setHtmlWidth(1300);
        pd4ml.setPageSize(pd4ml.changePageOrientation(PD4Constants.A4));
        pd4ml.setPageInsetsMM(new Insets(10, 20, 10, 10));   
  
        pd4ml.outputFormat(PD4Constants.PDF);  
	}
	
	private static PDFBuilder instance;
	
	public static PDFBuilder getInstance() {
		if(instance == null)
			instance = new PDFBuilder();
		return instance;
	}

	@Override
	public String getExtension() {
		return ".pdf";
	}

	@Override
	protected void doProcessFile() {
		String name = lastFile.getName();
        int endIndex = name.length() - 4;
        if(name.endsWith("l"))
        	endIndex--;
        name = name.substring(0, endIndex) + ".pdf";
        lastConvertedFile = new File(name); 
        FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(lastConvertedFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}  
		try {
        	pd4ml.render(new URL("file:"+lastFile.getPath()), fos);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}


}
