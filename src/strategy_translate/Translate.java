package strategy_translate;


public class Translate {
	
	public static void main(String[] args) {
		
		String msg = "Ciao mondo";
		
		System.out.println("Message in italian: " + msg);
		
		Translator t = new Translator(new GoogleTranslator("it", "es"));
		
		System.out.println("Message in english: " + t.getTranslatedText(msg));
		
		t.setStrategy(new MyMemoryTranslator("it", "es"));
		
		System.out.println("Message in spanish: " + t.getTranslatedText(msg));
		
	}
}
