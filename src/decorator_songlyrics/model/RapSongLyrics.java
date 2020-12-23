package decorator_songlyrics.model;

public class RapSongLyrics implements Lyrics {

	public RapSongLyrics() {}
	
	@Override
	public String getLyrics() {
		return "Brand new Lamborghini, fuck a cop car\n"
				+ "With the pistol on my hip like I'm a cop\n"
				+ "Have you ever met a real nigga rockstar?\n"
				+ "This ain't no guitar, bitch, this a glock";
	}

}
