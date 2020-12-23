package decorator_songlyrics.model;

public class PopSongLyrics implements Lyrics {

	public PopSongLyrics() {}
	
	@Override
	public String getLyrics() {
		
		return "Why you always in a mood?\n"
				+ "Fuckin' 'round, actin' brand new\n"
				+ "I ain't tryna tell you what to do\n"
				+ "But try to play it cool\n"
				+ "Baby, I ain't playing by your rules\n"
				+ "Everything look better with a view";
	}
	
}
