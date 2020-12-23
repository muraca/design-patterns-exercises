package adapter_builder_htmlconverter.model;

import java.io.File;
import javax.swing.filechooser.FileFilter;

import gui.ava.html.image.generator.HtmlImageGenerator;

//adapted HtmlImageGenerator to my FileBuilder interface
public class PNGBuilder extends FileBuilder{
	private HtmlImageGenerator hig = null;
	
	private PNGBuilder() {
		hig = new HtmlImageGenerator();
		fileFilter = new FileFilter(){
		    public String getDescription() {
		        return "PNG Files (*.png)";
		    }
		 
		    public boolean accept(File f) {
		        if (f.isDirectory()) {
		            return true;
		        } else {
		            return f.getName().toLowerCase().endsWith(".png");
		        }
		    }
		};
	}
	
	private static PNGBuilder instance = null;
	
	public static PNGBuilder getInstance() {
		if(instance == null)
			instance = new PNGBuilder();
		return instance;
	}

	@Override
	public String getExtension() {
		return ".png";
	}

	@Override
	protected void doProcessFile() {
		hig.loadHtml(FileBuilder.fileToString(lastFile));
        String name = lastFile.getName();
        int endIndex = name.length() - 4;
        if(name.endsWith("l"))
        	endIndex--;
        name = name.substring(0, endIndex) + ".png";
        lastConvertedFile = new File(name);
        hig.saveAsImage(lastConvertedFile);
		
	}

	
	
}
