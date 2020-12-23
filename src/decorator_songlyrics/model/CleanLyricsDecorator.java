package decorator_songlyrics.model;

public class CleanLyricsDecorator extends LyricsDecorator {
	
	private static String[] badWords = {"(?i)fuck", "(?i)nigga", "(?i)bitch"};
	private static String[] cleanWords = {"f*ck", "n***a", "b***h"};
	
	public CleanLyricsDecorator(Lyrics l) {
		super(l);
	}
	
	private static String censore(String message) {
		for(int i = 0; i < badWords.length; i++)
			message = message.replaceAll(badWords[i], cleanWords[i]);
         
        return message + "\n(Clean Version)";
    }
	
	@Override
	public String getLyrics() {
		
		return censore(lyrics.getLyrics());
	}

}
