package decorator_songlyrics.model;

public abstract class LyricsDecorator implements Lyrics {

	Lyrics lyrics;
	
	public LyricsDecorator(Lyrics l) {
		lyrics = l;
	}
	
	@Override
	public String getLyrics() {
		return lyrics.getLyrics();
	}

}
