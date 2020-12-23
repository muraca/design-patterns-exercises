package strategy_translate;

public abstract class TranslatorStrategy {
	protected String from;
	protected String to;

	public TranslatorStrategy(String from, String to) {
		this.from = from.substring(0,2);
		this.to = to.substring(0,2);
	}
	
	public abstract String getTranslatedText(String text);
}
