package strategy_translate;

public class Translator {

	private TranslatorStrategy strategy;

	public Translator(TranslatorStrategy strategy) {
		setStrategy(strategy);
	}
	
	public String getTranslatedText(String text) {
		return strategy.getTranslatedText(text);
	}
	
	public void setStrategy(TranslatorStrategy strategy) {
		this.strategy = strategy;
	}
}
