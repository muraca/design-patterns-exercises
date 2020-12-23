package adapter_builder_htmlconverter.model;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import javax.swing.filechooser.FileFilter;

//builder interface using template methods
public abstract class FileBuilder {
	protected FileFilter fileFilter = null;
	protected File lastFile;
	protected File lastConvertedFile = null;
	
	public File convertFile(File file) {
		loadFile(file);
		doProcessFile();
		return getLastConvertedFile();
	}
	
	protected void loadFile(File file) {
		lastFile = file;
	}

	protected abstract void doProcessFile();
	
	public File getLastConvertedFile() {
		return lastConvertedFile;
	}
	
	public FileFilter getFileFilter() {
		return fileFilter;
	}
	public String getExtension() {
		return "";
	}
	
	public static String fileToString(File f) {
		StringBuilder contentBuilder = new StringBuilder();
		 
        try (Stream<String> stream = Files.lines( Paths.get(f.toURI()), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
 
        return contentBuilder.toString();
	}
}
